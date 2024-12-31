# Drawing App
Basic application to:
- add shapes
- move shapes around
- select and remove shapes

## Build the app
```sh
./gradlew clean build
```

## Run the app
```sh
./gradlew run
```

## Assumptions
- shapes in toolbar expect a click to be added
- using same cursor for adding (click) and moving (drag) shapes; unable to get the "move" cursor for some reason.
- a shape can be selected or unselected by clicking it
- delete or backspace key works on a selected shape

## TODOs
- the toggle for the "selected" style could be improved
- shapes could possibly reuse the selection/unselection
- could still be cleaner