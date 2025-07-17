select count(*) as COUNT from ECOLI_DATA 
where ((GENOTYPE div 2)%2 != 1) and ((GENOTYPE%2 = 1) or ((GENOTYPE div 4)%2 = 1));