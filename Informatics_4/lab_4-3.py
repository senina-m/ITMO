import re


def find_numbers(text):
    pattern = re.compile(r"(?<=\s)\d+0\d(?=\s)")
    return re.findall(pattern, text)


def print_answer(result, answer):
    print("Мой ответ:" + answer)
    print("Верный ответ:" + result)


arr = [["108791237 pkh", "187912370"], ["190982, 987173", "199820"], ["00000, 0001", "00000 0100"],
       ["987028935", "987289350"], ["kjf0jkha", ""]]

for i in range(0, len(arr)):
    line_arr =[]
    a = find_numbers(arr[0])
    for j in a:
        line = a
        count = 0
        new_num = ""
        for k in range(0, ):
            if line[k] == 0:
                count = count + 1
            else:
                new_num = line[k] + new_num
        line_arr.append(new_num)
    print_answer(" ".join(line_arr), arr[1])
