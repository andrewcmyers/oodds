#include <stdio.h>
#include <stdlib.h>

union foo {
    int x;
    float y;
};

int main(int argc, char**argv) {
    union foo u;
    int j = u.x;
    u.y = atof(argv[1]);
    int i;

    for (i = 0; i < 32; i++) {
	printf("%d", (u.x & 0x80000000) ? 1 : 0);
	u.x <<= 1;
    }
}
