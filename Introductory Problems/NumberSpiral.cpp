#include <iostream>
using namespace std;
 
void printArray(int a[], int length) {
    for (int i = 0; i < length; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}
 
int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        long long x, y;
        cin >> x >> y;
        long long ans = 0;
        if (x % 2 == 0 && y % 2 == 0) {
            if (y <= x) {
                ans = x * x - y + 1;
            } else {
                ans = (y - 1) * (y - 1) + x;
            }
        } else if (x % 2 != 0 && y % 2 != 0) {
            if (y <= x) {
                ans = (x - 1) * (x - 1) + y;
            } else {
                ans = y * y - x + 1;
            }
        } else if (x % 2 == 0 && y % 2 != 0) {
            if (y <= x) {
                ans = x * x - y + 1;
            } else {
                ans = y * y - x + 1;
            }
        } else if (x % 2 != 0 && y % 2 == 0) {
            if (y <= x) {
                ans = (x - 1) * (x - 1) + y;
            } else {
                ans = (y - 1) * (y - 1) + x;
            }
        }
        cout << ans << endl;
    }
    return 0;
}