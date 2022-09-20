String filename;
try {
    for (int i = 0; i < args.length; i++) {
        switch (args[i]) {
            case "--file":
            filename = args[i+1];
            i++; // advance past filename
                 // as a one-liner: filename = args[++i];
            break;
            ...
        }
    }
} catch (ArrayIndexOutOfBoundsException e) {
    print_usage_message();
    return;
}
