/* TsurgeonParserTokenManager.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. TsurgeonParserTokenManager.java */
package edu.stanford.nlp.trees.tregex.tsurgeon;
import java.io.StringReader;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.util.Generics;
import edu.stanford.nlp.util.Pair;
import java.util.*;

/** Token Manager. */
@SuppressWarnings("unused")class TsurgeonParserTokenManager implements TsurgeonParserConstants {

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_2(){
   switch(curChar)
   {
      case 91:
         return jjStopAtPos(0, 5);
      case 97:
         return jjMoveStringLiteralDfa1_2(0x70000L);
      case 99:
         return jjMoveStringLiteralDfa1_2(0x88000L);
      case 100:
         return jjMoveStringLiteralDfa1_2(0x100L);
      case 101:
         return jjMoveStringLiteralDfa1_2(0x880L);
      case 105:
         return jjMoveStringLiteralDfa1_2(0x1040L);
      case 109:
         return jjMoveStringLiteralDfa1_2(0x2000L);
      case 112:
         return jjMoveStringLiteralDfa1_2(0x200L);
      case 114:
         return jjMoveStringLiteralDfa1_2(0x4400L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_2(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 100:
         return jjMoveStringLiteralDfa2_2(active0, 0x70000L);
      case 101:
         return jjMoveStringLiteralDfa2_2(active0, 0x4500L);
      case 102:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(1, 6);
         break;
      case 110:
         return jjMoveStringLiteralDfa2_2(active0, 0x1000L);
      case 111:
         return jjMoveStringLiteralDfa2_2(active0, 0x82000L);
      case 114:
         return jjMoveStringLiteralDfa2_2(active0, 0x8200L);
      case 120:
         return jjMoveStringLiteralDfa2_2(active0, 0x880L);
      default :
         return 2;
   }
   return 2;
}
private int jjMoveStringLiteralDfa2_2(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return 2;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 2;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa3_2(active0, 0x800L);
      case 101:
         return jjMoveStringLiteralDfa3_2(active0, 0x8000L);
      case 105:
         return jjMoveStringLiteralDfa3_2(active0, 0x80080L);
      case 106:
         return jjMoveStringLiteralDfa3_2(active0, 0x70000L);
      case 108:
         return jjMoveStringLiteralDfa3_2(active0, 0x500L);
      case 112:
         return jjMoveStringLiteralDfa3_2(active0, 0x4000L);
      case 115:
         return jjMoveStringLiteralDfa3_2(active0, 0x1000L);
      case 117:
         return jjMoveStringLiteralDfa3_2(active0, 0x200L);
      case 118:
         return jjMoveStringLiteralDfa3_2(active0, 0x2000L);
      default :
         return 3;
   }
}
private int jjMoveStringLiteralDfa3_2(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return 3;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_2(active0, 0x8400L);
      case 101:
         if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(3, 13);
         return jjMoveStringLiteralDfa4_2(active0, 0x1100L);
      case 105:
         return jjMoveStringLiteralDfa4_2(active0, 0x800L);
      case 108:
         return jjMoveStringLiteralDfa4_2(active0, 0x4000L);
      case 110:
         return jjMoveStringLiteralDfa4_2(active0, 0x80200L);
      case 111:
         return jjMoveStringLiteralDfa4_2(active0, 0x70000L);
      case 115:
         return jjMoveStringLiteralDfa4_2(active0, 0x80L);
      default :
         return 4;
   }
}
private int jjMoveStringLiteralDfa4_2(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return 4;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_2(active0, 0x4000L);
      case 98:
         return jjMoveStringLiteralDfa5_2(active0, 0x400L);
      case 100:
         return jjMoveStringLiteralDfa5_2(active0, 0x80000L);
      case 101:
         if ((active0 & 0x200L) != 0L)
            return jjStopAtPos(4, 9);
         break;
      case 105:
         return jjMoveStringLiteralDfa5_2(active0, 0x70000L);
      case 114:
         return jjMoveStringLiteralDfa5_2(active0, 0x1000L);
      case 115:
         return jjMoveStringLiteralDfa5_2(active0, 0x800L);
      case 116:
         return jjMoveStringLiteralDfa5_2(active0, 0x8180L);
      default :
         return 5;
   }
   return 5;
}
private int jjMoveStringLiteralDfa5_2(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return 5;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 5;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa6_2(active0, 0x4000L);
      case 101:
         if ((active0 & 0x100L) != 0L)
            return jjStopAtPos(5, 8);
         else if ((active0 & 0x800L) != 0L)
            return jjStopAtPos(5, 11);
         return jjMoveStringLiteralDfa6_2(active0, 0x88400L);
      case 110:
         if ((active0 & 0x10000L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 5;
         }
         return jjMoveStringLiteralDfa6_2(active0, 0x60000L);
      case 115:
         if ((active0 & 0x80L) != 0L)
            return jjStopAtPos(5, 7);
         break;
      case 116:
         if ((active0 & 0x1000L) != 0L)
            return jjStopAtPos(5, 12);
         break;
      default :
         return 6;
   }
   return 6;
}
private int jjMoveStringLiteralDfa6_2(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return 6;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 6;
   }
   switch(curChar)
   {
      case 70:
         if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(6, 18);
         break;
      case 72:
         if ((active0 & 0x20000L) != 0L)
            return jjStopAtPos(6, 17);
         break;
      case 83:
         return jjMoveStringLiteralDfa7_2(active0, 0x8000L);
      case 101:
         if ((active0 & 0x4000L) != 0L)
            return jjStopAtPos(6, 14);
         break;
      case 108:
         if ((active0 & 0x400L) != 0L)
            return jjStopAtPos(6, 10);
         break;
      case 120:
         if ((active0 & 0x80000L) != 0L)
            return jjStopAtPos(6, 19);
         break;
      default :
         return 7;
   }
   return 7;
}
private int jjMoveStringLiteralDfa7_2(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return 7;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 7;
   }
   switch(curChar)
   {
      case 117:
         return jjMoveStringLiteralDfa8_2(active0, 0x8000L);
      default :
         return 8;
   }
}
private int jjMoveStringLiteralDfa8_2(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return 8;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 8;
   }
   switch(curChar)
   {
      case 98:
         return jjMoveStringLiteralDfa9_2(active0, 0x8000L);
      default :
         return 9;
   }
}
private int jjMoveStringLiteralDfa9_2(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return 9;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 9;
   }
   switch(curChar)
   {
      case 116:
         return jjMoveStringLiteralDfa10_2(active0, 0x8000L);
      default :
         return 10;
   }
}
private int jjMoveStringLiteralDfa10_2(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return 10;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 10;
   }
   switch(curChar)
   {
      case 114:
         return jjMoveStringLiteralDfa11_2(active0, 0x8000L);
      default :
         return 11;
   }
}
private int jjMoveStringLiteralDfa11_2(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return 11;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 11;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa12_2(active0, 0x8000L);
      default :
         return 12;
   }
}
private int jjMoveStringLiteralDfa12_2(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return 12;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 12;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(12, 15);
         break;
      default :
         return 13;
   }
   return 13;
}
private final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 9:
         return jjStartNfaWithStates_0(0, 3, 13);
      case 41:
         return jjStopAtPos(0, 31);
      case 91:
         return jjStopAtPos(0, 5);
      case 93:
         return jjStopAtPos(0, 21);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 58;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0xfbfffcfeffffdbffL & l) != 0L)
                  {
                     if (kind > 29)
                        kind = 29;
                     { jjCheckNAdd(13); }
                  }
                  else if (curChar == 40)
                  {
                     if (kind > 30)
                        kind = 30;
                     { jjCheckNAdd(15); }
                  }
                  if ((0x240000000000L & l) != 0L)
                  {
                     if (kind > 24)
                        kind = 24;
                     { jjCheckNAdd(1); }
                  }
                  else if (curChar == 47)
                     { jjCheckNAddStates(0, 5); }
                  else if (curChar == 35)
                     { jjAddStates(6, 7); }
                  else if (curChar == 36)
                     { jjAddStates(8, 9); }
                  else if (curChar == 62)
                     { jjCheckNAddTwoStates(3, 4); }
                  if (curChar == 35)
                     { jjCheckNAdd(12); }
                  break;
               case 1:
                  if ((0x23ff240000000000L & l) == 0L)
                     break;
                  if (kind > 24)
                     kind = 24;
                  { jjCheckNAdd(1); }
                  break;
               case 2:
                  if (curChar == 62)
                     { jjCheckNAddTwoStates(3, 4); }
                  break;
               case 3:
                  if (curChar == 45)
                     { jjCheckNAdd(4); }
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 25)
                     kind = 25;
                  { jjCheckNAdd(4); }
                  break;
               case 6:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     { jjAddStates(10, 12); }
                  break;
               case 11:
                  if (curChar == 35)
                     { jjCheckNAdd(12); }
                  break;
               case 12:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 28)
                     kind = 28;
                  { jjCheckNAdd(12); }
                  break;
               case 13:
                  if ((0xfbfffcfeffffdbffL & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  { jjCheckNAdd(13); }
                  break;
               case 14:
                  if (curChar != 40)
                     break;
                  if (kind > 30)
                     kind = 30;
                  { jjCheckNAdd(15); }
                  break;
               case 15:
                  if ((0xf3fffcfa00000000L & l) == 0L)
                     break;
                  if (kind > 30)
                     kind = 30;
                  { jjCheckNAdd(15); }
                  break;
               case 16:
                  if (curChar == 36)
                     { jjAddStates(8, 9); }
                  break;
               case 17:
                  if (curChar == 45 && kind > 25)
                     kind = 25;
                  break;
               case 18:
                  if (curChar == 43 && kind > 25)
                     kind = 25;
                  break;
               case 19:
                  if (curChar == 35)
                     { jjAddStates(6, 7); }
                  break;
               case 36:
                  if (curChar == 47)
                     { jjCheckNAddStates(0, 5); }
                  break;
               case 37:
                  if (curChar == 47)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 39:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 40:
                  if (curChar == 47)
                     { jjCheckNAddStates(16, 18); }
                  break;
               case 41:
                  if (curChar == 61)
                     { jjCheckNAdd(42); }
                  break;
               case 42:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 23)
                     kind = 23;
                  { jjCheckNAddStates(19, 22); }
                  break;
               case 43:
                  if (curChar == 37)
                     { jjCheckNAdd(44); }
                  break;
               case 44:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 23)
                     kind = 23;
                  { jjCheckNAddStates(23, 26); }
                  break;
               case 45:
               case 49:
                  if (curChar == 47)
                     { jjCheckNAddStates(27, 29); }
                  break;
               case 46:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     { jjCheckNAddStates(27, 29); }
                  break;
               case 47:
                  if (curChar != 47)
                     break;
                  if (kind > 23)
                     kind = 23;
                  { jjCheckNAddStates(16, 18); }
                  break;
               case 52:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     { jjCheckNAddStates(30, 32); }
                  break;
               case 53:
                  if (curChar == 47 && kind > 26)
                     kind = 26;
                  break;
               case 55:
                  if (curChar == 47)
                     { jjCheckNAddStates(30, 32); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0xffffffffd7ffffffL & l) != 0L)
                  {
                     if (kind > 29)
                        kind = 29;
                     { jjCheckNAdd(13); }
                  }
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 24)
                        kind = 24;
                     { jjCheckNAdd(1); }
                  }
                  else if (curChar == 124)
                     { jjCheckNAddStates(10, 12); }
                  break;
               case 1:
                  if ((0x17fffffe87ffffffL & l) == 0L)
                     break;
                  if (kind > 24)
                     kind = 24;
                  { jjCheckNAdd(1); }
                  break;
               case 5:
               case 9:
                  if (curChar == 124)
                     { jjCheckNAddStates(10, 12); }
                  break;
               case 6:
                  if ((0xefffffffefffffffL & l) != 0L)
                     { jjCheckNAddStates(10, 12); }
                  break;
               case 7:
                  if (curChar == 124 && kind > 27)
                     kind = 27;
                  break;
               case 8:
                  if (curChar == 92)
                     { jjAddStates(33, 34); }
                  break;
               case 10:
                  if (curChar == 92)
                     { jjCheckNAddStates(10, 12); }
                  break;
               case 13:
                  if ((0xffffffffd7ffffffL & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  { jjCheckNAdd(13); }
                  break;
               case 15:
                  if ((0x7fffffffffffffffL & l) == 0L)
                     break;
                  if (kind > 30)
                     kind = 30;
                  jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 20:
                  if (curChar == 116 && kind > 22)
                     kind = 22;
                  break;
               case 21:
               case 29:
                  if (curChar == 115)
                     { jjCheckNAdd(20); }
                  break;
               case 22:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 23:
                  if (curChar == 109)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 24:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 23;
                  break;
               case 25:
                  if (curChar == 104)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 26:
                  if (curChar == 103)
                     jjstateSet[jjnewStateCnt++] = 25;
                  break;
               case 27:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 28:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 27;
                  break;
               case 30:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 29;
                  break;
               case 31:
                  if (curChar == 109)
                     jjstateSet[jjnewStateCnt++] = 30;
                  break;
               case 32:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 31;
                  break;
               case 33:
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 32;
                  break;
               case 34:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 33;
                  break;
               case 35:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 34;
                  break;
               case 38:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 37;
                  break;
               case 39:
                  { jjAddStates(13, 15); }
                  break;
               case 42:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 23)
                     kind = 23;
                  { jjCheckNAddStates(19, 22); }
                  break;
               case 44:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 23)
                     kind = 23;
                  { jjCheckNAddStates(23, 26); }
                  break;
               case 46:
                  if ((0xffffffffcfffffffL & l) != 0L)
                     { jjCheckNAddStates(27, 29); }
                  break;
               case 48:
                  if (curChar == 92)
                     { jjAddStates(35, 37); }
                  break;
               case 50:
                  if (curChar == 93)
                     { jjCheckNAddStates(27, 29); }
                  break;
               case 51:
                  if (curChar == 92)
                     { jjCheckNAddStates(27, 29); }
                  break;
               case 52:
                  if ((0xffffffffcfffffffL & l) != 0L)
                     { jjCheckNAddStates(30, 32); }
                  break;
               case 54:
                  if (curChar == 92)
                     { jjAddStates(38, 40); }
                  break;
               case 56:
                  if (curChar == 93)
                     { jjCheckNAddStates(30, 32); }
                  break;
               case 57:
                  if (curChar == 92)
                     { jjCheckNAddStates(30, 32); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 13:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 29)
                     kind = 29;
                  { jjCheckNAdd(13); }
                  break;
               case 6:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     { jjAddStates(10, 12); }
                  break;
               case 39:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     { jjAddStates(13, 15); }
                  break;
               case 46:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     { jjAddStates(27, 29); }
                  break;
               case 52:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     { jjAddStates(30, 32); }
                  break;
               default : if (i1 == 0 || l1 == 0 || i2 == 0 || l2 == 0) break; else break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 58 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private final int jjStopStringLiteralDfa_1(int pos, long active0){
   switch (pos)
   {
      default :
         return -1;
   }
}
private final int jjStartNfa_1(int pos, long active0){
   return jjMoveNfa_1(jjStopStringLiteralDfa_1(pos, active0), pos + 1);
}
private int jjMoveStringLiteralDfa0_1(){
   switch(curChar)
   {
      case 9:
         return jjStartNfaWithStates_1(0, 3, 0);
      case 91:
         return jjStopAtPos(0, 5);
      default :
         return jjMoveNfa_1(0, 0);
   }
}
private int jjStartNfaWithStates_1(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_1(state, pos + 1);
}
private int jjMoveNfa_1(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 1;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0xfbfffcfeffffdbffL & l) == 0L)
                     break;
                  kind = 20;
                  jjstateSet[jjnewStateCnt++] = 0;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0xffffffffd7ffffffL & l) == 0L)
                     break;
                  kind = 20;
                  jjstateSet[jjnewStateCnt++] = 0;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjstateSet[jjnewStateCnt++] = 0;
                  break;
               default : if (i1 == 0 || l1 == 0 || i2 == 0 || l2 == 0) break; else break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 1 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   38, 39, 40, 52, 53, 54, 28, 35, 17, 18, 6, 7, 8, 38, 39, 40, 
   41, 43, 45, 41, 42, 43, 45, 41, 43, 44, 45, 46, 47, 48, 52, 53, 
   54, 9, 10, 49, 50, 51, 55, 56, 57, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, "\133", "\151\146", "\145\170\151\163\164\163", 
"\144\145\154\145\164\145", "\160\162\165\156\145", "\162\145\154\141\142\145\154", 
"\145\170\143\151\163\145", "\151\156\163\145\162\164", "\155\157\166\145", 
"\162\145\160\154\141\143\145", "\143\162\145\141\164\145\123\165\142\164\162\145\145", 
"\141\144\152\157\151\156", "\141\144\152\157\151\156\110", "\141\144\152\157\151\156\106", 
"\143\157\151\156\144\145\170", null, "\135", null, null, null, null, null, null, null, null, null, "\51", };
protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 2;
int defaultLexState = 2;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   switch(curLexState)
   {
     case 0:
       try { input_stream.backup(0);
          while (curChar <= 32 && (0x100002400L & (1L << curChar)) != 0L)
             curChar = input_stream.BeginToken();
       }
       catch (java.io.IOException e1) { continue EOFLoop; }
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_0();
       break;
     case 1:
       try { input_stream.backup(0);
          while (curChar <= 32 && (0x100002400L & (1L << curChar)) != 0L)
             curChar = input_stream.BeginToken();
       }
       catch (java.io.IOException e1) { continue EOFLoop; }
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_1();
       break;
     case 2:
       try { input_stream.backup(0);
          while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
             curChar = input_stream.BeginToken();
       }
       catch (java.io.IOException e1) { continue EOFLoop; }
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_2();
       break;
   }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else
        {
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public TsurgeonParserTokenManager(SimpleCharStream stream){

      if (SimpleCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");

    input_stream = stream;
  }

  /** Constructor. */
  public TsurgeonParserTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream)
  {
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 58; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream, int lexState)
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState)
  {
    if (lexState >= 3 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public static final String[] lexStateNames = {
   "OPERATION",
   "CONDITIONAL",
   "DEFAULT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, 2, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0xffffffe1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
    protected SimpleCharStream  input_stream;

    private final int[] jjrounds = new int[58];
    private final int[] jjstateSet = new int[2 * 58];

    
    protected char curChar;
}