A classic 2D video game written in Java, where the objective is to control a line as it grows in length while preventing it from hitting the bounds or itself

How to start the game?
- type: make; make run

Operating System?
- MacOS Catalina

JDK Version?
- 12.0.2

NOTE:
1. screen size is 1280*700, since that's my max computer screen size
2. user can switch between levels anytime they want, however game status will only be preserved when they are already in the game
3. reset or quit or game over will not preserve game status
4. snake moves 1 segment every 400 msecs at level 1, 200 msecs at level 2, 100 msecs at level 3
5. game is repainted 25 times per second
6. src/utils/Draw.drawCenteredString() is a third-party method from https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
7. Trophy icon represents the current Level number


DIRECTORY BREAKDOWN:
src/assets: hold icons and pictures used

src/utils: holds shared helpers, utlity functions

src/*.java:
1. Main.java is the entry point
2. Board.java acts like a controller
3. Fruit.java and Snake.java act as models, hold relavant data respectively
4. Splash.java and Quit.java are only used for repainting purposes to lighten up Board.java

