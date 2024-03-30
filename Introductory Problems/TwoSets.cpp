#include <iostream>
#include <unordered_set>
using namespace std;
 
void helper(int n, unordered_set<int>& HS1, unordered_set<int>& HS2) {
    int i, j;
    for (i = 1; i <= n / 4; i++) {
        HS1.insert(i);
    }
    for (j = n; j > n - n / 4; j--) {
        HS1.insert(j);
    }
    while (i != j + 1) {
        HS2.insert(i);
        i++;
    }
}
 
int main() {
    int n;
    cin >> n;
    if (n == 1 || n == 2) {
        cout << "NO" << endl;
        return 0;
    }
    if (n % 2 == 0) {
        if ((n / 2) % 2 == 0) {
            unordered_set<int> HS1, HS2;
            helper(n, HS1, HS2);
            cout << "YES" << endl;
            cout << HS1.size() << endl;
            for (auto key : HS1) {
                cout << key << " ";
            }
            cout << endl;
            cout << HS2.size() << endl;
            for (auto key : HS2) {
                cout << key << " ";
            }
        } else {
            cout << "NO" << endl;
        }
    } else {
        if (((n + 1) / 2) % 2 == 0) {
            unordered_set<int> HS1, HS2;
            helper(n - 1, HS1, HS2);
            HS1.insert(n);
            cout << "YES" << endl;
            cout << HS1.size() << endl;
            for (auto key : HS1) {
                cout << key << " ";
            }
            cout << endl;
            cout << HS2.size() << endl;
            for (auto key : HS2) {
                cout << key << " ";
            }
        } else {
            cout << "NO" << endl;
        }
    }
    return 0;
}
