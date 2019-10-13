# Brainfuck Graphics API

#### Features 

- Draw or Fill Rectangles, Elipses, or Triangles in any colour.
- Portable 
- Lightning Fast Development of Graphical Brainfuck applications when compared to other API’s 

#### Crash Course

​	The program interprets certain API calls in the first 16 bytes of memory within the BrainfuckVM. The first byte is a flag to be set when the API call should be made. The Second byte is a operation code to specify which function call should be made. The remaining 14 bytes are interpreted as args for the specified function. 

| Function Name   | Operation Code | Arguments                                                   | Description                                                  |
| --------------- | -------------- | ----------------------------------------------------------- | ------------------------------------------------------------ |
| `SET_COLOR`     | `0x10`         | `r, g, b` <br />where each is a byte                        | Sets the color to draw primitives with                       |
| `DRAW_RECT`     | `0x20`         | `x1, y1, x2, y2`<br />where each is a two-byte word         | Draws Rectangle with the given upper-left and bottom-right coordinates |
| `FILL_RECT`     | `0x21`         | `x1, y1, x2, y2`<br />where each is a two-byte word         | Fills Rectangle with the given upper-left and bottom-right coordinates |
| `DRAW_ELLIPSE`  | `0x22`         | `x1, y1, x2, y2`<br />where each is a two-byte word         | Draws an Ellipse bounded by a rectangle with the given upper-left and bottom-right coordinates |
| `FILL_ELLIPSE`  | `0x23`         | `x1, y1, x2, y2`<br />where each is a two-byte word         | Fills an Ellipse bounded by a rectangle with the given upper-left and bottom-right coordinates |
| `DRAW_TRIANGLE` | `0x24`         | `x1, y1, x2, y2, x3, y3`<br />where each is a two-byte word | Draws a Triangle with the given coordinates                  |
| `FILL_TRIANGLE` | `0x25`         | `x1, y1, x2, y2, x3, y3`<br />where each is a two-byte word | Fills a Triangle with the given coordinates                  |

