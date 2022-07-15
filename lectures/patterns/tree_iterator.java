 Iterator<T> iterator() {
    if (left != null)
	for (T x : left)
	    yield x;
    yield data;
    if (right != null)
	for (T x : right)
	    yield x;
 }
