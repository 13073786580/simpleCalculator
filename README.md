# simpleCalculator
A simple Calculator based on RPN

<h1>基于RPN的命令行计算器<h1></br>
<h2>操作符<h2>
  1.undo 回退</br>
  2.clear 清空</br>
  3.sqrt 开方</br>
  
<hr>
Example 1</br>
expression: 5 2</br>
stack: 5 2</br>

<hr>
Example 2</br>
expression: 2 sqrt</br>
stack: 1.4142135623</br>
expression: clear 9 sqrt</br>
stack: 3</br>

<hr>
Example 3</br>
expression: 5 2 -</br>
stack: 3</br>
expression: 3 -</br>
stack: 0</br>
expression: clear</br>
stack:</br>

<hr>
Example 4</br>
expression: 5 4 3 2</br>
stack: 5 4 3 2</br>
expression: undo undo *</br>
stack: 20</br>
expression: 5 *</br>
stack: 100</br>
expression: undo</br>
stack: 20 5</br>
