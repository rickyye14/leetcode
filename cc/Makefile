CC = g++
DEBUG = -g
C11 = -std=c++0x
CFLAGS = -O2 -Wall $(DEBUG) $(C11) -c
LFLAGS = -O2 -Wall
.SUFFIXES: .cc .o .bin
.cc.bin:
	$(CC) $(CFLAGS) $*.cc -o $*.o
	$(CC) $(LFLAGS) $*.o -o $*.bin

PROGS = \
		two_sum.cc \

default: bin

bin: $(PROGS:.cc=.bin)

clean:
	$(RM) *.o *.bin
