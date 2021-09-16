package graph
//https://leetcode.com/problems/flood-fill/
fun main() {

    var row1 = arrayOf(1,1,1).toIntArray()
    var row2 = arrayOf(1,1,0).toIntArray()
    var row3 = arrayOf(1,0,1).toIntArray()

    var imageArray = arrayOf(row1,row2,row3)
    floodFill(imageArray, 1,1,2)
}

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {

    floodFillUtility(image, sr, sc, newColor, image.size, image[0].size)
    return image
}

fun floodFillUtility(image:Array<IntArray>,sr: Int,sc: Int, newColor: Int, rowLength:Int, columnLength:Int){

    if(sr > rowLength || sc > columnLength)
        return
    if(image[sr][sc] == 0)
        return

    image[sr][sc] = newColor

    floodFillUtility(image, sr + 1, sc, newColor, rowLength, columnLength)
    floodFillUtility(image, sr -1, sc, newColor, rowLength, columnLength)
    floodFillUtility(image, sr, sc + 1, newColor, rowLength, columnLength)
    floodFillUtility(image, sr, sc - 1, newColor, rowLength,columnLength)

}