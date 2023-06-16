class Shape {
  double s;
  public double area() {
    return 0;
  }
}

class Triangle extends Shape {
  double height;
  double base;

  @Override
  public double area() {
    s = (base * height)/2;
    return s;
  }
}

class Circle extends Shape {
  double radius;

  @Override
  public double area() {
    s = Math.PI * radius * radius;
    return s;
  }
}

class Square extends Shape {
  double side;

  @Override
  public double area() {
    s = side * side;
    return s;
  }
}

class Rectangle extends Shape {
  double width;
  double height;

  @Override
  public double area() {
    s = width * height;
    return s;
  }
}
