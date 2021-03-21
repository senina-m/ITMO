import re


def find_re(text):
    # pattern = re.compile(r"[A-Z]\w+[^.?!\s]\s+(\b\w+\b\s+){,4}\b\w+\b\?")
    pattern = re.compile(r"[A-Z]\w+(?:\s+\w+){0,5}\?")
    return re.findall(pattern, text)


filename_for_parsing = "RomeoAndJuliet.txt"
filename_for_result = "lab_4-2_output.txt"

file_read = open(filename_for_parsing, "r", encoding='utf-8').read()
file_write = open(filename_for_result, "w", encoding='utf-8')

line = "\n".join(find_re(file_read))
file_write.write(line)
