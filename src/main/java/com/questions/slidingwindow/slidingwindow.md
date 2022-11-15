Used to reduce O(N*2) solutions to O(N). There are two variant of sliding window algorithm
- Fixed Variant: Windows size is fixed e.g max sum of subarray of size k.
- Dynamic Variant: Window size is not fixed e.g. smallest sum with less then some value s.
- Dynamic variant with aux datastructure: auxilary datastructure means we are using something like HashMap or Hashset e.g. longest string with no more than k distinct character

# How to recognise
To recognise a problem will solve using sliding window algorithm we need to judge algo on following criteria
1. If we have to iterate sequentially i.e contiguous sequence of elements
2. Problem is around String, Array, list 
3. Windows size is given or not.

# Example
finding following 
1. min
2. max
3. longest
4. shortest
5. contains

# resource
https://zengruiwang.medium.com/sliding-window-technique-360d840d5740
https://www.youtube.com/watch?v=MK-NZ4hN7rs
https://www.youtube.com/watch?v=EHCGAZBbB88&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj
https://medium.com/techie-delight/top-problems-on-sliding-window-technique-8e63f1e2b1fa