Object co = new LList<String>();

if (co instanceof LList<String>) ... // illegal
if (co instanceof LList<?>)      ... // legal
if (co instanceof LList)         ... // legal but discouraged

LList<String> ls = (LList<String>) co; // legal but only partly checked
LList<?>      ls = (LList<?>) co;      // legal
LList<String> ls = (LList<?>) co;      // illegal
LList<String> ls = (LList)co;          // legal but discouraged
