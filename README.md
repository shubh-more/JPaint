# JavaCodesShub
Initial commit

This is my JPAint Standalone Application

1. This is my first sprint 1

2. I have draw a filled-in Rectangle

3. And Undo/Redo Draw

As requested in sprint 1
https://github.com/ShubhCodesss/JavaCodesShub


Sprint 2
In this sprint I have implemented 
1. Drawing Rectangles, Ellipses, and Triangles
2. Drawing shapes with various colors
3. Drawing shapes with various shading types
4. Select a shape and move a shape

Also i have implemented two design pattern that is Command pattern and Observer Pattern

<<<<<<< HEAD
Except abstract factory pattern in sprint 1, there are totally 4 new patterns implemented 
1.Builder Pattern Shape class implement builder pattern so other class are able to create shape through build pattern. 
2. Strategy Pattern Strategy pattern use for mouse mode run() method, this includes IStrategy interface and Context for switching mode. 
3. Observer Pattern MovementAlert class implement observer pattern, it allows SelectCommand to add observer(s) (selected shape(s)), and MoveCommand to update the new coordinate to all observer(s).
 This requires IMovementObserver interface to share similar methods. 
4. MVC Pattern We already have View (UI) initiated in main, so I create ShapeList as data model and MouseController as controller to satisfy 
with MVC pattern

Sprint 2
https://github.com/ShubhCodesss/JavaCodesShub

=======
Except abstract factory pattern in sprint 1, there are totally 4 new patterns implemented
1.Builder Pattern
Shape class implement builder pattern so other class are able to create shape through build pattern.
2. Strategy Pattern
Strategy pattern use for mouse mode run() method, this includes IStrategy interface and Context for switching mode.
3. Observer Pattern
MovementAlert class implement observer pattern, it allows SelectCommand to add observer(s) (selected shape(s)), and MoveCommand to update the new coordinate to all observer(s). This requires IMovementObserver interface to share similar methods.
4. MVC Pattern
We already have View (UI) initiated in main, so I create ShapeList as data model and MouseController as controller to satisfy with MVC pattern
>>>>>>> 73f306f6e8ccbfc7b66d0a2a486ec998365748e3
