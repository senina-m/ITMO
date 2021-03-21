import time


class Node:
    def __init__(self):
        self.node_name = ""
        self.body = ""
        self.children = []


def print_node(node, file):
    file.write(node.node_name + ": " + node.body)


def print_children(node, file):
    length = len(node.children)
    if length != 0:
        file.write(node.node_name + ": {")
        for j in range(0, length - 1):
            print_children(node.children[j], file)
            file.write(", \n")
        print_children(node.children[length - 1], file)
        file.write("}")
    if node.body != "":
        print_node(node, file)


def write_2_file(node, file):  # печатаем структуру в файл
    if node.node_name == "root":
        for j in range(0, len(node.children) - 1):
            print_children(node.children[j], file)
            file.write(", \n")
        print_children(node.children[len(node.children) - 1], file)
    else:
        print_children(node, file)


start_time = time.time()

filename_for_parsing = "my-schedule.xml"
filename_for_result = "my-new-schedule_1.json"

file_read = open(filename_for_parsing, "r", encoding='utf-8')
file_write = open(filename_for_result, "w", encoding='utf-8')

name = False
body = False
this_name = ""
this_body = ""

line = ""
array = file_read.read().split('\n')
for i in range(1, len(array)):
    line = line + array[i]

root = Node()
root.node_name = "root"
this_node = root
parents = []
k = -1
for i in range(0, len(line)):
    symbol = line[i]
    if i < len(line) - 1:
        next_symbol = line[i + 1]
    else:
        next_symbol = ""

    if symbol == "<" and next_symbol != "/":  # Новый тег node
        node = Node()
        this_node.children.append(node)
        parents.append(this_node)
        k = k + 1
        this_node = node
        name = True
        body = False
    if name and symbol != "<" and symbol != ">":  # читаем имя node
        this_name = this_name + symbol
    elif name and symbol == ">":  # записываю имя node
        name = False
        body = True
        this_node.node_name = this_name
        this_name = ""

    if body and symbol != ">" and symbol != "<":  # читаем body
        this_body = this_body + symbol
    elif symbol == "<" and next_symbol == "/":  # записываем body, если тег закрылся
        body = False
        this_node.body = this_body
        this_body = ""
        this_node = parents[k]
        parents.pop()
        k = k - 1

file_write.write("{ ")
write_2_file(root, file_write)
file_write.write("\n}")
print("--- %s seconds ---" % (time.time() - start_time))
