class Solution:
    def add_2_bit(self, bit1, bit2):
        current = bit1 ^ bit2
        carrier = bit1 & bit2
        return current, carrier

    def add_bit(self, bit1, bit2, carrier):
        current1, carrier1 = self.add_2_bit(bit1, bit2)
        current2, carrier2 = self.add_2_bit(current1, carrier)
        return current2, carrier1 + carrier2

    def add(self, a: int, b: int) -> int:
        bits = []
        carrier = 0
        current = 0
        for i in range(32):
            bita = a >> i & 1
            bitb = b >> i & 1
            current, carrier = self.add_bit(bita, bitb, carrier)
            bits.insert(0, str(current))
        # bits.insert(0, str(carrier))
        return int("".join(bits), 2)

if __name__ == '__main__':
    so = Solution()
    res = so.add(-2, 1)
    print(res)