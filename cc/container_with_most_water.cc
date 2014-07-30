#include "base_include.h"

class container_with_most_water {
public:
    int maxArea(vector<int> &height) {
        int left = 0;
        int right = height.size() - 1;
        int area = 0;
        int max_area = 0;
        for ( ; left < right; ) {
            area = (right - left) * min(height[left], height[right]);
            if (max_area < area) {
                max_area = area;
            }
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return max_area;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
