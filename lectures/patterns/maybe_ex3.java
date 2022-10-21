Maybe<String> m = ...;

String new_s = m.then(s -> "(" + s + ")")
                .orElseGet(() -> {
                    System.err.println("No string found");
                    return "";
                });
