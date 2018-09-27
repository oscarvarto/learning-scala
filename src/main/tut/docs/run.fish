#!/usr/bin/env fish

set name functions

pandoc \
-f markdown+tex_math_single_backslash+inline_code_attributes+fenced_divs \
-s -N \
--bibliography scala-essentials.bib \
--variable colorlinks=true \
--filter pandoc-latex-fontsize \
--filter pandoc-latex-admonition \
{$name}.md \
-o {$name}.pdf \
#--verbose