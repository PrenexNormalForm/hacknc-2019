zero = '[-]'

def split_bytes(short):
    return (short // 256) % 256, short % 256

def color(r, g, b):
    s = '>'
    s += '+' * 0x10
    s += '>' + '+' * r
    s += '>' + '+' * g
    s += '>' + '+' * b
    s += '<<<<+'
    s += ('>' + zero) * 4
    s += '<<<<'
    return s

def rect(x1, y1, x2, y2, fill=False, opcode=0x20):
    b1, b2 = split_bytes(x1)
    b3, b4 = split_bytes(y1)
    b5, b6 = split_bytes(x2)
    b7, b8 = split_bytes(y2)
    bites = [b1, b2, b3, b4, b5, b6, b7, b8]
    s = '>'
    s += '+' * opcode
    if fill:
        s += '+'
    for b in bites:
        s += '>' + '+' * b
    s += '<' * (len(bites) + 1)
    s += '+'
    s += ('>' + zero) * (len(bites) + 1)
    s += '<' * (len(bites) + 1)
    return s

def ellipse(x1, y1, x2, y2, fill=False):
    return rect(x1, y1, x2, y2, fill, 0x22)

def triangle(x1, y1, x2, y2, x3, y3, fill=False):
    b1, b2 = split_bytes(x1)
    b3, b4 = split_bytes(y1)
    b5, b6 = split_bytes(x2)
    b7, b8 = split_bytes(y2)
    b9, b10 = split_bytes(x3)
    b11, b12 = split_bytes(y3)
    bites = [b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12]
    s = '>'
    s += '+' * 0x24
    if fill:
        s += '+'
    for b in bites:
        s += '>' + '+' * b
    s += '<' * (len(bites) + 1)
    s += '+'
    s += ('>' + zero) * (len(bites) + 1)
    s += '<' * (len(bites) + 1)
    return s

if __name__ == '__main__':
    f = open('the_fuck.bf', 'w')
    f.write(color(214, 26, 54))
    f.write(triangle(250, 100, 275, 75, 225, 75))
    f.write(ellipse(200, 100, 300, 200, fill=True))
    f.write(ellipse(175, 200, 325, 400, fill=True)) #body
    f.write(color(199, 78, 114))
    f.write(triangle(100, 225, 190, 250, 100, 245, fill=True))
    f.write(triangle(400, 225, 310, 250, 400, 245, fill=True))
    f.write(triangle(225, 390, 225, 500, 200, 500, fill=True))
    f.write(triangle(275, 390, 275, 500, 300, 500, fill=True))
    f.write(color(209, 243, 255))
    f.write(ellipse(225,130,240,140, fill=True))
    f.write(ellipse(260,130,275,140, fill=True))
    f.write(color(255, 255, 252))
    f.write(triangle(225, 170, 275, 170, 250, 185, fill=True))
    f.close()