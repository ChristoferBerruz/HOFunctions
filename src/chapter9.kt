/**
 * This Exercises are from the Modern Programming Languages from Sebesta, Chapter 9.
 */
//1
fun il2rl(nums:List<Int>): List<Double> = nums.map { it*1.0 }
//3
fun squarelist(nums:List<Int>): List<Int> = nums.map { it*it }
//5
fun inclist(nums:List<Int>, inc:Int):List<Int> = nums.map { it+inc }
//7
fun bor(bools: List<Boolean>): Boolean = if(bools.isEmpty()) false else bools.fold(false){c,item -> c || item}
//9
fun bxor(bools:List<Boolean>): Boolean = (bools.fold(0){c:Int, item:Boolean -> if(item) c+1 else c}% 2 != 0)
//11
fun <T> mylength(a:List<T>): Int = if(a.isEmpty()) 0 else a.fold(0){c, item -> c+1}
//13
fun truecount(a:List<Boolean>):Int = a.fold(0){c, item -> if(item) c+1 else c}
//15
fun myimplode(a:List<Char>): String = a.fold(""){c, item -> c+item}
//17
fun max(a:List<Int>):Int = if(a.isEmpty()) 0 else a.fold(0){cMax, item -> if(cMax<item) item else cMax}
//19
fun member(e:Int, a:List<Int>): Boolean = a.fold(false){c, item -> (e == item)||c}
//21
fun less(e:Int, a:List<Int>): List<Int> = a.fold(listOf()){c,item -> if(item<e) c + listOf<Int>(item) else c}
//23
fun convert(a:List<Pair<Int, Int>>): Pair<List<Int>, List<Int>> =
    a.fold(Pair(listOf(), listOf())){c, item -> Pair(c.first+ listOf<Int>(item.first), c.second+ listOf<Int>(item.second))}
//25
fun eval(a:List<Double>, x:Double):Double = a.foldRight(0.0){c, item -> c+item*x}

/**
 * Note that init is the accumulator. foldl and foldr only work with functions of (Int, Int) -> Int.
 */
//27
fun foldl(a:List<Int>, init: Int, cr:(Int, Int) -> Int): Int{
    if(a.size == 1) return cr(init, a[0])
    else{
        return foldl(a.subList(1, a.size), cr(init, a[0]), cr)
    }
}
//28
fun foldr(a:List<Int>, init:Int, cr: (Int,Int)-> Int): Int{
    if(a.size==1) return cr(init, a[0])
    else{
        return foldr(a.subList(0, a.size-1), cr(init, a[a.size-1]), cr)
    }
}