#include <iostream>
#include <fstream>
#include <algorithm>
using namespace std;

int main() {
    int pos[3];
    ifstream fin ("herding.in");
    ofstream fout ("herding.out");
    fin >> pos[0] >> pos[1] >> pos[2];
    sort(begin(pos), end(pos));
    if (pos[0] +2== pos[2]) {
        fout << "0\n";
            // great its already clustered
    }
    else if (pos[1]==pos[0]+2) {
        fout << "1\n";
            // great it needs some cluster
    }
    else if (pos[2]== pos[1]+2) {
        fout << "1\n";
            // great it need some cluster
    } else fout << "2\n"; // COWs ARE EVERYWHERE HELP
    fout << max(pos[1]-pos[0], pos[2]-pos[1])-1 << "\n";// -1 get rid of off by one
    return 0;

}
