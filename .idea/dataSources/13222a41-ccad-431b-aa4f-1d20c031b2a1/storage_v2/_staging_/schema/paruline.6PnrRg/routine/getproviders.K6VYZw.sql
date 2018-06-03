create procedure getProviders()
  BEGIN
    SELECT id_fourniss, name_f, adresse_f, phoneFour, city, cp FROM fournisseur F, city C
      WHERE F.id_city = C.id_city;
  END;

