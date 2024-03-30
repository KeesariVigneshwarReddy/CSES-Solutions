#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;
 
void printArray(char a[], int n) {
    for (int i = 0; i < n; i++) {
        cout << a[i];
    }
    cout << endl;
}
 
int main() {
    string str;
    cin >> str;
    unordered_map<char, int> HM;
    for (int i = 0; i < str.length(); i++) {
        HM[str[i]]++;
    }
    int odd_freq_count = 0;
    for (auto& pair : HM) {
        if (pair.second % 2 != 0) {
            odd_freq_count++;
        }
    }
    if (odd_freq_count <= 1) {
        char ans[str.length()];
        int i = 0, j = str.length() - 1;
        char odd_key = '?';
        for (auto& pair : HM) {
            int freq = pair.second;
            if (freq % 2 != 0) {
                odd_key = pair.first;
                continue;
            }
            for (int k = 1; k <= freq / 2; k++) {
                ans[i++] = pair.first;
                ans[j--] = pair.first;
            }
        }
        if (odd_key != '?') {
            for (int k = 0; k < HM[odd_key]; k++) {
                ans[i++] = odd_key;
            }
        }
        printArray(ans, str.length());
    } else {
        cout << "NO SOLUTION" << endl;
    }
    return 0;
}
