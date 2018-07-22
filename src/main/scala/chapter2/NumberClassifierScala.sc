/** 필터(filter) **/

//각 숫자가 3으로 나뉘어야 한다는 조건을 가진 코드 블록을 filter() 함수를 적용한다.
val numbers = List.range(1, 11)
numbers filter (x => x % 3 == 0)
//res0: List[Int] = List(3, 6, 9)

//스칼라에서는 매개변수를 언더바로 치환하는게 가능하므로 더 간결하게 코드를 짤 수 있다.
numbers filter (_ % 3 == 0)
//res1: List[Int] = List(3, 6, 9)

val words = List("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog")
words filter (_.length == 3)
//res2: List[String] = List(the, fox, the, dog)

//스칼라의 필터 연산 중 다른 한 가지는 컬렉션을 여러 조각으로 분리한 결과를 리턴하는 partition() 함수
//분리 조건을 정하는 함수를 전달하여 어떻게 분리할지를 정한다.
//다음 partition() 함수는 3으로 나뉘는가 여부에 따라 분리된 두 목록을 리턴한다.
numbers partition (_ % 3 == 0)
//res3: (List[Int], List[Int]) = (List(3, 6, 9),List(1, 2, 4, 5, 7, 8, 10))

//filter() 함수는 조건에 맞는 요소들의 컬렉션을 리턴하는 반면, find() 함수는 조건을 만족시키는 첫번째 요소만 리턴한다.
numbers find (_ % 3 == 0)
//res4: Option[Int] = Some(3)

numbers find (_ < 0)
//res5: Option[Int] = None

//컬렉션에서 주어진 술어 함수에 만족시키는 요소를 간직하거나 또는 버리는 함수들도 가지고 있다.
//takeWhile() 함수는 컬렉션의 앞에서부터 술어함수를 만족시키는 값들의 최대 집합을 리턴한다.
List(1, 2, 3, -4, 5, 6, 7, 8, 9, 10) takeWhile (_ > 0)
//res6: List[Int] = List(1, 2, 3)


// dropWhile() 함수는 술어 함수를 만족시키는 최다수의 요소를 건너뛴다.
words dropWhile (_ startsWith ("t"))
//res7: List[String] = List(quick, brown, fox, jumped, over, the, lazy, dog)


/** 맵(map) **/
//모든 함수형 언어에서 볼 수 있는 맵.
//맵 함수는 함수와 컬렉션을 받아서 이 함수를 각 요소에 적용한 후 컬렉션을 리턴한다.
//리턴된 컬렉션은 개개의 값은 변했지만 필터의 경우와는 달리 원래 컬렉션과 크기는 같다.

List(1, 2, 3, 4, 5) map (_ + 1)
//res8: List[Int] = List(2, 3, 4, 5, 6)

//map() 함수는 컬렉션의 각 요소가 변형된 값을 리턴하는 것 외에 아래 경우에는 문자열의 각 요소의 길이를 목록으로 리턴한다.
words map (_.length)
//res9: List[Int] = List(3, 5, 5, 3, 6, 4, 3, 4, 3)

//중첩을 펼치는 연산을 플래트닝(Flattening)이라고 한다.
List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9)) flatMap (_.toList)
//res10: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

//flatMap() 함수는 전통적인 의미에서 중첩되지 않은 것처럼 보이는 자료구조에도 적용된다.
//문자열의 목록은 중첩된 문자들의 배열로 볼 수 있다.
//words flatMap  (_.toList)
//res11: List[Char] = List(t, h, e, q, u, i, c, k, b, r, o, w, n, f, o, x, j, u, m, p, e, d, o, v, e, r, t, h, e, l, a, z, y, d, o, g)

/** 폴드(fold)/리듀스(reduce) **/
//스칼라는 동적 타이핑 언어인 그루비나 클로저에서는 다루지 않는 다양한 자료형 시나리오들을 해결해야 하기 때문에 폴드 연산 종류가 가장 다양하다.

//합계를 내는 데에는 리듀스를 주로 사용한다.
List.range(1, 10) reduceLeft ((a, b) => a + b)
//res12: Int = 45

List.range(1, 10) reduceLeft (_ + _)
//res12: Int = 45

//reduceLeft() 함수는 첫째 요소가 연산의 좌항이라고 간주한다. 덧셈은 피연산자의 위치에 상관없지만, 나눗셈과 같은 경우에는 순서가 중요하다.
//연산자가 적용되는 순서를 뒤바꾸려면 reduceRight()를 사용하라.
//reduceRight() 함수는 피연산자의 순서를 바꾸는 것이 아니라, 연산의 방향을 뒤바꾼다.
//8 - 9를 먼저 연산하고, 그 결과를 다음 연산의 두번째 매개변수로 사용한다.
List.range(1, 10) reduceRight (_ - _)
// 8 - 9 = -1
// 7 - (-1) = 8
// 6 - 8 = -2 ...
//res13: Int = 5

//리듀스와 같은 고수준의 추상 개념을 어떤 경우에 사용하는 가를 터득하는 것이 함수형 프로그래밍을 마스터하는 방법 중의 하나이다.
//이 예제는 reduceLeft()를 사용하여 컬렉션에 들어있는 가장 긴 단어를 찾아낸다.
words.reduceLeft((a, b) => if (a.length > b.length) a else b)
//res14: String = jumped

//리듀스와 폴드는 서로 중복되는 기능을 가지고 있지만 조금씩 차이가 있다.
//스칼라에서 reduceLeft[B>:A](op: (B,A) => B) :B의 시그니처를 보면 각 요소를 결합시키는 함수가 유일한 매개변수이다.
//초기값은 컬렉션의 첫번째 요소로 간주한다.
//반면에 foldLeft[B](z:B)(op:(B,A) =>B):B의 시그니처는 초기 시드 값을 포함하기 때문에 목록의 요소와 다른 자료형의 리턴값을 가능하게 해준다.
List.range(1,10).foldLeft(0)(_ + _)
//res15: Int = 45

//스칼라는 연산자 오버로딩을 지원한다.
//자주 사용되는 두 폴드 연산 foldLeft와 foldRight는 상응하는 연산자 /:과 :\가 있다.
//foleLeft를 사용한 합의 더욱 간결한 버전을 만들어보자.
(0 /: List.range(1,10)) (_ + _)
//res16: Int = 45

//foldRight() 함수나 :\ 연산자를 사용하여 목록 각 요소간의 계단식 차를 구할 수 있다.
(List.range(1,10) :\ 0) (_ - _)
//res17: Int = 5