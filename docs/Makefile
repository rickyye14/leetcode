PDFS = leetcode_category.pdf \
		resource.pdf
LATEX = pdflatex

all:	$(PDFS)

leetcode_category.pdf: leetcode_category.tex
	$(LATEX) $<

resource.pdf: resource.tex
	$(LATEX) $<

clean:
	-rm -f *~ *.out *.aux *.dvi *.ps *.pdf *.toc *.lof *.log *.lot *.flg *.bbl *.blg *.idx *.ind *.ilg *.snm *.nav *.fig.bak

view-cat:
	xdg-open leetcode_category.pdf

view-res:
	xdg-open resource.pdf
