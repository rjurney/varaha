define POSTagger varaha.text.StanfordPOSTagger('src/resources/test/english-left3words-distsim.tagger');
documents    = LOAD 'src/resources/test/test1.txt' AS (text:chararray);
posAnnotated    = FOREACH documents GENERATE  POSTagger(text)
                 AS (b:bag{token:tuple(word:chararray, tag:chararray)});


