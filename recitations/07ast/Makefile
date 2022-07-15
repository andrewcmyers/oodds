SINGLE_SOURCE := ast.xetex
NO_EXTENSIONS := $(basename $(SINGLE_SOURCE))    # make basename gives the path without the extension
COMPILED_PDFS := $(SINGLE_SOURCE:.xetex=.pdf)    # change <single source>.xetex to <single source>.pdf
# Used in the cleaning targets.
EXTENSIONS    := .aux .blg .out .bbl .log .nav .snm .toc .vrb .pyg .fdb_latexmk .fls
CLEANABLES    := $(foreach file, $(NO_EXTENSIONS), \
                     $(foreach ext, $(EXTENSIONS), \
                         $(file)$(ext)))
# Minted can produce undesireables on different platforms, destroy them all.
MINTED        := $(foreach partial, $(NO_EXTENSIONS), \
                     $(shell dirname $(partial))/_minted-$(shell basename $(partial)))
TYPE          := $(shell uname -s)

all: $(COMPILED_PDFS)

$(COMPILED_PDFS): %.pdf: %.xetex
	latexmk -xelatex -pdf -dvi- --shell-escape --jobname=$(basename $(shell basename $@)) $(shell basename $<)

.PHONY: clean realclean
clean:
	rm -f $(CLEANABLES)
	rm -rf $(MINTED)


realclean: clean
	rm -f $(COMPILED_PDFS)
