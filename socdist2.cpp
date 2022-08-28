
#include <iostream>
#include <fstream>
using namespace std;

int N, D[1000001];
int findradius(void) {
    int radius = 2000000, curr = -1;
    for (int n=0; n < 1000001; n++) {
        if (D[n] !=0) {
                if (curr!=-1) {
                if (D[curr]!=D[n]) {
                    if (n-curr < radius) {
                        radius = n-curr;
                    }
                    // update
                }

        }
        curr = n;
        }
    }
    return radius;
}
/*
sickchains  repersent chains of sick people
isolated outside of r, like 15, who is sick but not sick by
the main cluster
*/
int isolated(void) {
    int last = 0; int chain=0;
    for (int n=0; n <= 1000000; n++) {
        if (D[n] != 0) {
        if (D[n] != last) {
        if ( D[n] == 1)chain++;


        }
        last = D[n];

    }
    }
    return chain;
    }
/*
Find blocks that are spread by one cow, break at radius
*/
int spread(int r)
{
  int block = 0, start = 0;
  for (int i=0; i<=1000000; i++)
    if (D[i] != 0) {
      if (start!=0) {
        if (D[start]==1 ) {
        if (D[i]==1 && i-start>=r)  {
            block++;

      }

      }
      }
      start = i;

    }
  return block;
}


int main(void) {
  ifstream fin ("socdist2.in");
  ofstream fout ("socdist2.out");
  int x, c;
  fin >> N;
  for (int i=0; i<N; i++) {
    fin >> x >> c;
    if (c==1) {
        D[x] = 1;
    }
    if (c==0) {
        D[x] = -1;
    }
  }
    int r = findradius();
    std::cout << spread(r);
    fout << isolated() + spread(r) << "\n";
    return 0;

}
