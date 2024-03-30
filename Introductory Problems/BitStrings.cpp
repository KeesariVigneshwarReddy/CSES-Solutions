#include <bits/stdc++.h>
using namespace std;
int main() 
{
    long long M = 1000000007; 
    long long n;
    cin >> n;
    long long output = 1;
    for (int i = 1; i <= n; i++)
    {
        output = (output * 2) % M;
    }
    cout << output << endl;
