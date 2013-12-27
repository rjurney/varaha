
documents    = LOAD 'src/resources/test/test1.txt' AS (text:chararray);
posAnnotated    = FOREACH documents GENERATE  varaha.text.StanfordPOSTagger(text)
                 AS (b:bag{token:tuple(word:chararray, tag:chararray)});


