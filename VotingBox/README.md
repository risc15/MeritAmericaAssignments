# KarelVotingBox
Karel program to clear out hanging chads from a voter's ballot. 

Instructions:
=============

Suppose  that  your  state  legislature has determined that the voter’s intent is indicated by the  status  of  the  square  in  the  middle  of  the  rectangle,  
which  is  where  the  stylus  makes contact  with  the  card.    If  there  is  a  beeper  in  that  position,  Karel  must  assume  that  the voter did not 
intend to cast a vote in that column and move on to the next.  If there is no beeper  in  the  center  square,  Karel  must  check  the  other  two  squares  in  
the  ballot  and remove  any  and  all  beepers  so  that  the  ballot  can  be  counted  correctly.

This program assumes:
=====================

* The  world  consists  of  a  single  row  of  ballot  rectangles  that  appear  on  every  even intersection,  as  shown in  the  sample  world.    
  The  size  of  the  ballot,  however,  may  be different  from  the  one  shown  in  the  example  in  the  sense  that  it  may  contain  any number of ballot 
  rectangles.  In any case, the card will begin one square to the left of the first rectangle and end one square to the right of the last rectangle.
  
* Every ballot rectangle is exactly one space wide and three spaces high, as shown in the diagram.

* Karel always begins immediately to the left of the first ballot rectangle, facing the hole that gives Karel access to the voting area along the center line of the 
  rectangles.
  
* Karel must finish execution facing east at the rightmost edge of the ballot.
