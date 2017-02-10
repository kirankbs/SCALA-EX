package dataorcode

import org.junit.Assert._
import org.junit.Test

/**
  * Created by kirankumar on 25-09-2016.
  */
class NatTest {

  val zero = Zero;

  @Test
  def testZeroNat(): Unit ={
    //when
    val expected = zero;
    //then
    assertTrue(expected.isZero)
  }

  @Test
  def testZeroToSuccessor(): Unit ={
    //given
    val expected = 1
    //when
    val nat1 = zero.successor
    //then
    assertEquals(expected,nat1.length)
  }

  @Test(expected = classOf[Error])
  def testZeroToPredecessor(): Unit ={
    val zeroPred = zero.predecessor
  }

  @Test
  def testZeroPlusSucceesor(): Unit ={
    //given
    val nat5 = new Succ(Zero).successor.successor.successor.successor
    //when
    val natX = Zero + nat5
    //then
    assertEquals(nat5,natX)
  }

  @Test(expected = classOf[Error])
  def testZeroMinusSuccNessor(): Unit ={
    //given
    val nat5 = new Succ(Zero).successor.successor.successor.successor
    //when
    val natX = Zero - nat5
  }

  @Test
  def testZeroPlusZeor(): Unit ={
    //when
    val natX = zero + Zero
    //then
    assertEquals(zero,natX)
  }

  @Test
  def testZeroMinusZero(): Unit ={
    //when
    val natX = Zero - zero
    //then
    assertEquals(zero,natX)
  }

  @Test
  def testSuccessor(): Unit ={
    //given
    val nat1 = Zero.successor
    val expected = false
    //when
    val actual = nat1.isZero
    //then
    assertEquals(expected,actual)

  }

  @Test
  def testSuccessorToSuccessor(): Unit ={
    //given
    val nat1 = Zero.successor
    val expected = 5
    //when
    val nat5 = nat1.successor.successor.successor.successor
    //then
    assertEquals(expected,nat5.length)
  }

  @Test
  def testNatToZeroByPredecessor(): Unit ={
    //given
    val nat2 = zero.successor.successor
    //when
    val actual = nat2.predecessor.predecessor
    //then
    assertTrue(actual.isZero)
  }

  @Test
  def testSuccessorPlusSuccessor(): Unit ={
    //given
    val nat2 =Zero + new Succ(Zero).successor.successor
    val expected = 5
    //when
    val nat5 = nat2 + zero.successor.successor
    //then
    assertEquals(expected,nat5.length)
  }

  @Test
  def testSuccessorPlusZero(): Unit ={
    //given
    val nat2 = zero.successor.successor
    //when
    val actual = nat2 + Zero
    //then
    assertEquals(nat2.length,actual.length)
  }

  @Test
  def testSuccessorMinusSuccessor(): Unit ={
    //given
    val nat2 = zero.successor.successor
    val nat3 = nat2.successor
    //when
    val nat5 = nat2 + nat3
    //then
    assertTrue(nat5.length == 5)
  }

  @Test(expected = classOf[Error])
  def testSuccessorMinusGreaterSuccessor(): Unit ={
    //given
    val nat2 = zero.successor.successor
    val nat3 = nat2.successor
    //when
    val actual = nat2 - nat3
    //then
  }

  @Test
  def testSuccessorMinusZero(): Unit ={
    //given
    val nat2 = zero.successor.successor
    //when
    val actual = nat2 - zero
    //then
    assertEquals(nat2,actual)

  }
}
