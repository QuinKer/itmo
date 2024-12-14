from functools import reduce
from re import compile, DOTALL
number_regex = compile(r"(-?(?:0|[1-9]\d*)(?:\.\d+)?(?:[eE][+-]?\d+)?)\s*(.*)", DOTALL)
string_regex = compile(r'("(?:[^\\]|\\["\\/bfnrt]|\\u[0-9a-fA-F]{4})*?")\s*(.*)', DOTALL)
def parse_number(string: str):
	match = number_regex.match(string.strip())
	if match is not None:
		number, string = match.groups()
		return eval(number),string.strip()
def parse_string(string: str):
	match = string_regex.match(string.strip())
	if match is not None:
		res, string = match.groups()
		return res[1:-1], string.strip()


def parse_bool(string: str):
	if string.startswith("true"):
		return True, string[4:].strip()
	if string.startswith("false"):
		return False, string[5:].strip()


def parse_null(string: str):
	if string.startswith("null"):
		return None, string[4:].strip()


def parse_colon(string: str):
	if string.startswith(":"):
		return ":", string[1:].strip()


def parse_comma(string: str):
	if string.startswith(","):
		return ",", string[1:].strip()


def parse_key_value(string: str):
	parsed_string = parse_string(string)
	if parsed_string is None:
		return None
	parsed_colon = parse_colon(parsed_string[1])
	if parsed_colon is None:
		return None
	parsed_value = parse_value(parsed_colon[1])
	if parsed_value is None:
		return None
	return (parsed_string[0], parsed_value[0]), parsed_value[1].strip()


def parse_comma_sep_values(string: str):
	res = []
	while True:
		parsed_value = parse_value(string)
		if parsed_value is None:
			break
		res.append(parsed_value[0])
		string = parsed_value[1]

		parsed_comma = parse_comma(string)
		if parsed_comma is None:
			break
		string = parsed_comma[1]
	if not res:
		return None
	return res, string.strip()


def parse_comma_sep_keyvalues(string: str):
	res = {}
	while True:
		parsed_keyvalue = parse_key_value(string)
		if parsed_keyvalue is None:
			break
		key, value = parsed_keyvalue[0]
		res[key] = value
		string = parsed_keyvalue[1]

		parsed_comma = parse_comma(string)
		if parsed_comma is None:
			break
		string = parsed_comma[1]
	if not res:
		return None
	return res, string.strip()


def parse_array(string: str):
	if not string.startswith("["):
		return None
	parsed_sep_values = parse_comma_sep_values(string[1:].strip())
	if parsed_sep_values is not None:
		arr,string = parsed_sep_values
	else:
		arr,string = [],string[1:]
	if not string.startswith("]"):
		return None
	return arr,string[1:].strip()


def parse_object(string: str):
	if not string.startswith("{"):
		return None
	parsed_sep_keyvalues = parse_comma_sep_keyvalues(string[1:].strip())
	if parsed_sep_keyvalues is not None:
		arr,string = parsed_sep_keyvalues
	else:
		arr,string = {},string[1:]
	if not string.startswith("}"):
		return None
	return arr,string[1:].strip()


def parse_value(string: str):
	res = reduce(
		lambda a, b: a if a(string) else b,
		[
			parse_number,
			parse_string,
			parse_bool,
			parse_null,
			parse_array,
			parse_object,
		],
	)(string)
	if res is None:
		return None
	else:
		return res[0], res[1].strip()

def all2xml(jdict,root_tag = "root"):
	xml = ""
	for key, value in jdict.items():
		standart_keys = key.replace(" ","_")
		open_tag = f"<{standart_keys}>"
		close_tag = f"</{standart_keys}>"

		if isinstance(value,dict):
			xml += all2xml(value,key)
		elif isinstance(value,list):
			xml += (
				open_tag +
				"".join([all2xml({"element": elem}, "") for elem in value])
				+ close_tag
			)
		else:
			xml += open_tag + str(value) + close_tag

	if root_tag == "":
		return xml
	return f'<{root_tag.replace(" ","_")}>' + xml + f'</{root_tag.replace(" ","_")}>'

def parse_json(string: str):
	string = string.strip()
	parsed_value = parse_value(string)

	if parsed_value is None:
		raise ValueError("not a valid JSON")
	if parsed_value[1].strip():
		raise ValueError("not a valid JSON")

	return parsed_value[0]