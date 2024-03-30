#include <iostream>
#include <vector>
#include <cmath>
#include <bitset>
using namespace std;
 
void printArray(vector<int>& a) {
    for (int i = 0; i < a.size(); i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}
 
int main() {
    int n;
    cin >> n;
    int max = pow(2, n);
    vector<string> AL;
    for (int i = 0; i < max; i++) {
        string curr = bitset<32>(i).to_string().substr(32 - n);
        int n_0 = n - curr.length();
        string normal(n_0, '0');
        normal += curr;
        string ans;
        ans.push_back(normal[0]);
        for (int k = 1; k < normal.length(); k++) {
            ans.push_back(((normal[k - 1] - '0') ^ (normal[k] - '0')) + '0');
        }
        AL.push_back(ans);
    }
 
    for (int i = 0; i < max; i++) {
        cout << AL[i] << endl;
    }
    return 0;
}