# Inheritance Demo

## Visualizing Class/Interface Relationships
On a piece of paper or a whiteboard
draw a diagram with each class or interface
in the `shapes` package of this project represented as a rectangle
with the name of the class or interface written inside
it. Draw an arrow with an "is-a" label from
a class or interface that "implements" or "extends" to the class or
interface mentioned to the right of the "implements" or "extends" keyword.

If a class has a simple data member that is of the
type of another
class or interface in the package draw an arrow from that
class to the type of its field with a "has-a" label.

If a class as a data member that is an array or collection
of the type of another class or interface in the package
draw an array from that class to the type of the
array or collection it has as a member with a "has-n" label.

## Box is-a Polygon

Note that an instance of the `Box` class
is always initialized by invoking the `super`
constructor of its super-class `Polygon`
so it "has" an `ArrayList<Point>` in its `Polygon`
part ***and*** it has 4 `int`s in its `Box` part.

Experiment with commenting out the `Box.equals()`
method and running `ShapeTest.main()`.
Does it cause any errors or odd looking-behavior?

Now experiment with commenting out the `Box.toString()`
method and running `ShapeTest.main()`.
Again, does this cause any errors or odd-looking behavior?
Where does the `.toString()` method come from when printing
out a `Box` object?

Finally, experiment with commenting out the `Box.contains()`
method and running `ShapeTest.main()`. This doesn't
work! Why?

## Triangle Class

Add a new class to represent triangles. How
should it fit with the other classes in the
diagram you drew earlier?

Look at the `Triangle` constructor required in the
commented out code in `ShapeTest`. Implement
a constructor that `ShapeTest` can use and
pattern it after the first line of the constructor used by `Box`
that invokes `super()`.

Which of the following can you recycle the
from the `Polygon` class?

* `boundingBox()`
* `contains()`
* `equals()`
* `toString()`

Uncomment the last few lines of `ShapeTest.main()` to
see how well your `Triangle` works!