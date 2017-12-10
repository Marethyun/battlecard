# A battle card game simulator (closed battle)
To simulate a game, launch the builded jar like this:

`java -jar Battlecard.jar [<players> <picks>] [logfile]`

players: The number of players in the game (at least 2)
picks  : The number of picks (of traditional 54 cards)
logfile: The output file name in which the battle log will be saved

By specifying any of these parameters the game starts with 2 players,
1 pick and no logfile.
The logfile is optional.

e.g: `java -jar Battlecard.jar 4 2 example.log`
Will simulate a game with 4 players, 2 picks (108 cards), and
save the game to the file `example.log` in the same directory than the
jarfile.


