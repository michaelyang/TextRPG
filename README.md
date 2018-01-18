# TextRPG

Making a text based game, similar to the adventure gamebooks I used to read/play as a child. Users will be able to start a storyline, given a set of choices along the way (some options will only be available with certain stat/item requirement), and allowed to "rebirth" at the end of the game, or restart the game from the beginning while retaining all gained stats. Stats can only be gained through achievements unlocked along the way.

## Demo
[![Demo](http://img.youtube.com/vi/vlwdBNCzGH4/0.jpg)](http://www.youtube.com/watch?v=vlwdBNCzGH4 "mTicketSpoof Demo
")

Click to watch video

## Learned

* Getting used to using SharedPreferences, JSON, hashmaps, classes, etc.
* Creating custom views
* Correctly setting up splashscreen (only showing the splash while things load instead of having it show for a set amount of time)
* The importance of having a clear and detailed plan for each class... instead of struggling to decide where to put things as I go

## Questions

* When to use activity vs. view vs. fragment vs. anything else I don't know about.
* Correctly using SharedPreferences and what to store and how. (How to split up Character, stats, achievements, items, inventory, etc.)
* How to have a "global" object that is persistent throughout all activies. Is this what SharedPreference should be used for, initializing it for evey single activity? Or is there a better way to do this?

## To-do
* Writing a controller to convert stored json data (items, stories, choices)

## Authors

* **Me**
