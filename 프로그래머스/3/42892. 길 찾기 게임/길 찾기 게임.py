import sys
sys.setrecursionlimit(10**8)

def insert(tree, node, parent_idx):
    idx, x, y = node
    (px, py), left, right = tree[parent_idx]
    
    if px < x:
        if right != 0:
            insert(tree, node, right)
        else:
            tree[parent_idx][2] = idx
            tree[idx] = [(x,y),0,0]
    else:
        if left != 0:
            insert(tree, node, left)
        else:
            tree[parent_idx][1] = idx
            tree[idx] = [(x,y),0,0]
def pre_order(tree, idx):
    path = []
    if idx == 0:
        return path
    path.append(idx)
    path+=pre_order(tree, tree[idx][1])
    path+=pre_order(tree, tree[idx][2])
    return path

def post_order(tree, idx):
    path = []
    if idx == 0:
        return path
    path+=post_order(tree, tree[idx][1])
    path+=post_order(tree, tree[idx][2])
    path.append(idx)
    return path
    
def solution(nodeinfo):
    new_nodeinfo = []
    for idx, [x,y] in enumerate(nodeinfo, 1):
        new_nodeinfo.append([idx, x, y])
    new_nodeinfo.sort(key = lambda x:x[2])
    
    tree = {}
    root_idx, root_x, root_y = new_nodeinfo.pop()
    tree[root_idx] = [(root_x, root_y),0,0]
    while new_nodeinfo:
        node = new_nodeinfo.pop()
        insert(tree, node, root_idx)
    answer = [pre_order(tree, root_idx), post_order(tree, root_idx)]
    return answer