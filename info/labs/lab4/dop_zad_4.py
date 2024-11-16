import time


start_time = time.perf_counter()
for i in range(100):
    import main
end_time = time.perf_counter()

print(f"Основа - {end_time - start_time}")

start_time = time.perf_counter()
for i in range(100):
    import dop_zad_1
end_time = time.perf_counter()

print(f"Доп 1  - {end_time - start_time}")

start_time = time.perf_counter()
for i in range(100):
    import dop_zad_2
end_time = time.perf_counter()

print(f"Доп 2  - {end_time - start_time}")

start_time = time.perf_counter()
for i in range(100):
    import dop_zad_3
end_time = time.perf_counter()

print(f"Доп 3  - {end_time - start_time}")