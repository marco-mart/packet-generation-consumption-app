The packet has the following structure:
packet = <header><payload>, where
<header> = <start_of_packet><packet_counter>
<payload> = <key><length><values>
<start_of_packet> = 0x2b00
<packet_counter> = 2-byte integer starƟng at 0 and is incremented
<key> = unique 2-byte integer that idenƟfies the structure of <values>
<length> = 2-byte integer denoƟng the length of <values> in bytes
<values> = defined by the table below, based on <key>

Key (in hex) Length (in bytes) Values
0x0100 16 Null-terminated string; max length=15 chars + \0
0x0110 32 Array of 32-bit unsigned integers, size = 8
0x0201 13 16-bit signed integer
16-bit signed integer
32-bit float
5-char array

Receive the generated packet and display the byte representation
of the packet and the generated data within the packet.
