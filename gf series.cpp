//Siddhant made a special series and named it as G.F Series.The series follows this trend  Tn=(Tn-2)2-(Tn-1)  in which the first and the second term are 0 and 1 respectively.Help Siddhant to find  upto N terms of the series .
#include<bits/stdc++.h>
using namespace std;
ll gfSeries(ll n){
    if(n==0){
        return 0;
    }
    if(n==1){
        return 1;
    }
    return pow(gfSeries(n-2),2)-gfSeries(n-1);    
}
int main() {
	//code
	int t;
	cin>>t;
	while(t--){
	    ll n;
	    cin>>n;
	    for(ll i=0;i<n;i++){
	        cout<<gfSeries(i)<<" ";
	    }
	    cout<<'\n';
	    
	}
	return 0;
}
