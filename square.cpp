int x[4];
int y[4];
#include <fstream>
#include <algorithm>
#include <cstdlib>
#include<cmath>
using namespace std;
int main() {
    /* logic consider the least and greatest points x,y
    minus and max the diff of width length
    */
    ifstream fin("square.in");
	ofstream fout("square.out");
	fin >> x[0] >> y[0] >> x[1] >> y[1];
	fin >> x[2] >> y[2] >> x[3] >> y[3];
	int diff = abs(*(max_element(begin(x), end(x)))-*(min_element(begin(x), end(x))));
	int diffy = abs( *(max_element(begin(y), end(y)))-*(min_element(begin(y), end(y))));
	fout << pow(max(diff, diffy),2);

}
