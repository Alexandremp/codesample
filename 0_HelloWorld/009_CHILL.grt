text_hello_world:
MODULE
DCL
outfile ASSOCIATION,
output TEXT (80) DYNAMIC,
size INT:= 12345,
flag BOOL:= FALSE,
set SET (a,b,c) := b,
s1 CHARS (5) := "Hello",
s2 CHARS (5) VARYING:= "World";

ASSOCIATE (outfile,"OUTPUT.TXT"); - - associate the output file
CREATE (outfile); - - create it
CONNECT (output,outfile,WRITEONLY); - - then connect text location
WRITETEXT (output,"%B%/",10); - - 1010
WRITETEXT (output,"%C%/",set); - - b
WRITETEXT (output,"size = %C%/",size); - - size = 12345
WRITETEXT (output,"%CL6%C i/o%/",s1,s2); - - CHILL text i/o
WRITETEXT (output,"flag =%X%C",flag); - - flag = FALSE
size := GETTEXTINDEX (output); - - 12
DISSOCIATE (outfile);
END text_hello_world;
