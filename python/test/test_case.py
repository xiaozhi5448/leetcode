import unittest


# 被测试的函数或类
def add(a, b):
    return a + b


class Calculator:
    def multiply(self, a, b):
        return a * b


# 测试用例类
class TestAddFunction(unittest.TestCase):
    def test_add_integers(self):
        self.assertEqual(add(1, 2), 3)

    def test_add_floats(self):
        self.assertAlmostEqual(add(1.1, 2.2), 3.3, places=1)

    def test_add_strings(self):
        self.assertEqual(add('hello', ' world'), 'hello world')


class TestCalculator(unittest.TestCase):
    def setUp(self):
        """在每个测试方法前运行"""
        self.calc = Calculator()

    def tearDown(self):
        """在每个测试方法后运行"""
        pass  # 可以在这里进行清理工作

    def test_multiply_integers(self):
        self.assertEqual(self.calc.multiply(3, 4), 12)

    def test_multiply_by_zero(self):
        self.assertEqual(self.calc.multiply(5, 0), 0)


# 运行测试
if __name__ == '__main__':
    unittest.main()