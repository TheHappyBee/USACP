#include <iostream>
#include <algorithm>
using namespace std;
int arr[7];

int main(void) {
    for (int i=0; i < 7; i++) {
        cin >> arr[i];
    }
    int n = sizeof(arr) / sizeof(arr[0]);
    sort(arr, arr + n);
    int c = arr[n-1] - (arr[0]+arr[1]);
    cout << arr[0] << ' ' << arr[1] << ' ' << c;
}
