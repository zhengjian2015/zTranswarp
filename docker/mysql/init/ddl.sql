CREATE TABLE categories (
  id BIGINT NOT NULL,
  created_at BIGINT NOT NULL,
  display_order BIGINT NOT NULL,
  updated_at BIGINT NOT NULL,
  version BIGINT NOT NULL,
  tag VARCHAR(32) NOT NULL,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(1000) NOT NULL,
  PRIMARY KEY(id)
) Engine=INNODB DEFAULT CHARSET=UTF8MB4;

INSERT INTO categories (name, tag, description, display_order, id, created_at, updated_at, version) VALUES ('Sample', 'sample', 'Java Series', 0, 1279976691204512, 1557025248747, 1557025248747, 0);


CREATE TABLE articles (
  id BIGINT NOT NULL,
  category_id BIGINT NOT NULL,
  created_at BIGINT NOT NULL,
  image_id BIGINT NOT NULL,
  publish_at BIGINT NOT NULL,
  text_id BIGINT NOT NULL,
  updated_at BIGINT NOT NULL,
  user_id BIGINT NOT NULL,
  version BIGINT NOT NULL,
  views BIGINT NOT NULL,
  name VARCHAR(100) NOT NULL,
  tags VARCHAR(100) NOT NULL,
  description VARCHAR(1000) NOT NULL,
  INDEX IDX_CAT_PUB (category_id,publish_at),
  PRIMARY KEY(id)
) Engine=INNODB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE texts (
  id BIGINT NOT NULL,
  created_at BIGINT NOT NULL,
  updated_at BIGINT NOT NULL,
  version BIGINT NOT NULL,
  hash VARCHAR(64) NOT NULL,
  content TEXT NOT NULL,
  CONSTRAINT UNI_HASH UNIQUE (hash),
  PRIMARY KEY(id)
) Engine=INNODB DEFAULT CHARSET=UTF8MB4;

INSERT INTO articles (user_id, category_id, image_id, text_id, views, tags, name, description, publish_at, id, created_at, updated_at, version) VALUES (1279976691204128, 1279976691204512, 1279976691204576, 1279976691205312, 0, 'abc,xyz,hello', 'consetetur. 0', 'equidem referrentur tibique animal dolor omittantur sumo vituperata tincidunt.', 1557025248734, 1279976691208032, 1557025248752, 1557025248752, 0);
INSERT INTO texts (hash, content, id, created_at, updated_at, version) VALUES ('7bf414a87ad92aaa77e6bf9da70445830e17fe5ff990732487872debe3faff4a', '# adipisci adhuc per.\n\nfaucibus mi sadipscing consectetur rhoncus ornatus instructior elaboraret ubique neque consetetur.\n\ncomprehensam iusto inani gubergren facilis ante adhuc signiferumque amet veniam impetus inani.\n\neripuit signiferumque verterem verterem suas.\n\nleo convallis intellegebat magnis molestie vituperatoribus sapien iudicabit curae netus possim.\n\nmei etiam offendit arcu sea mediocritatem corrumpit urbanitas eripuit honestatis in phasellus commodo partiendo debet ultricies principes repudiandae duis intellegat.\n\nidque inimicus posidonium vehicula convenire molestiae interesset no dicit offendit efficitur litora sagittis.\n\nneglegentur oporteat malesuada dolorem intellegat nobis vocibus metus vidisse accumsan singulis dolorum theophrastus.\n\ndocendi repudiare inciderint dapibus nulla phasellus detraxit blandit sadipscing dico quot conceptam luptatum fuisset eos fabellas iudicabit suspendisse.\n\nfalli ridiculus platea cubilia luctus dolores mentitum ridiculus tempus vel dui vivamus vitae.\n\ncondimentum senectus deseruisse causae viderer aperiri viderer ocurreret porta conceptam imperdiet.\n\n', 1279976691205344, 1557025248753, 1557025248753, 0);
INSERT INTO articles (user_id, category_id, image_id, text_id, views, tags, name, description, publish_at, id, created_at, updated_at, version) VALUES (1279976691204128, 1279976691204512, 1279976691204640, 1279976691205344, 0, 'abc,xyz,hello', 'docendi. 1', 'orci harum doming lorem sale gravida dolor.', 1557025248735, 1279976691208064, 1557025248753, 1557025248753, 0);
INSERT INTO texts (hash, content, id, created_at, updated_at, version) VALUES ('25d2389f7b6866fba03eaa45b773821a43c4f3c4796c33a99d0274e4353e0360', '# iuvaret.\n\nmolestie antiopam voluptaria has dicant theophrastus feugait quot suspendisse.\n\nmea sodales at quis orci scelerisque scelerisque turpis omittantur vis.\n\npostea nunc solet tacimates petentium singulis platonem dicunt libris mea recteque maiorum.\n\niisque antiopam minim evertitur accumsan sit vero feugait sadipscing esse.\n\neloquentiam porro.\n\nocurreret ligula efficitur conceptam vocent mollis scripserit legimus sed scripserit tota.\n\ndictum aeque labores sem atqui convenire.\n\nqualisque mei liber reformidans semper ex utinam arcu fames scripta inani delicata ne molestie honestatis.\n\ninceptos homero imperdiet epicurei solet viris curae volumus vehicula eget doctus dignissim.\n\ninstructior persius nostra efficitur quot eget mollis porro sociis maecenas alterum consectetuer vel consectetur veritus.\n\natqui nominavi definiebas rutrum epicurei facilis eam mediocrem accusata possit dolorum sententiae vidisse.\n\nmetus agam dicunt dolores cetero atomorum.\n\ngraece.\n\nelit efficiantur curabitur mutat definitiones eget has pellentesque deserunt molestie dis iaculis felis per augue invenire quaerendum.\n\nutamur nostrum inceptos dolore faucibus affert nibh omittam metus arcu.\n\n', 1279976691205376, 1557025248753, 1557025248753, 0);
INSERT INTO articles (user_id, category_id, image_id, text_id, views, tags, name, description, publish_at, id, created_at, updated_at, version) VALUES (1279976691204128, 1279976691204512, 1279976691204704, 1279976691205376, 0, 'abc,xyz,hello', 'eloquentiam. 2', 'praesent ridiculus fabellas rutrum ignota sollicitudin dolores non arcu civibus.', 1557025248736, 1279976691208096, 1557025248753, 1557025248753, 0);
INSERT INTO texts (hash, content, id, created_at, updated_at, version) VALUES ('d49f4713edc3bcd33b2acc3730f1c86e57e5d1082b329a976e0955b7fedc448e', '# discere semper offendit vestibulum feugait sem prompta nibh doming.\n\net disputationi consequat libris referrentur graecis aliquet ad graece.\n\nmetus sem option etiam explicari.\n\nrepudiandae delicata tempor erat.\n\nlobortis invidunt falli affert adolescens penatibus convallis posuere quot.\n\nintellegebat elaboraret.\n\nmagnis fringilla autem aenean consequat his mediocrem quis explicari et graeco torquent has sale et esse.\n\nmattis detracto aliquip error vix magnis veri pri quas ocurreret melius patrioque dicit nibh.\n\npericula vel disputationi facilisi eripuit eripuit indoctum inani.\n\nsuscipit graecis tibique mel disputationi sociis blandit class pharetra dictum magnis habitasse bibendum feugiat reformidans.\n\nmauris fuisset odio nascetur rutrum causae maiestatis referrentur taciti adversarium offendit sociis falli eu cetero expetenda minim mucius.\n\ngraecis eum putent tractatos fastidii cursus eius scelerisque rhoncus impetus primis autem.\n\npostea consul scripserit porro persius aenean purus putent platonem unum eius ea scripserit lorem iudicabit referrentur malesuada movet id.\n\nconubia eos ultrices singulis iuvaret.\n\neuripidis aliquam movet alia sea lacinia invenire odio finibus cum vivendo libero aliquip nascetur consectetuer habitant.\n\n', 1279976691205408, 1557025248753, 1557025248753, 0);
INSERT INTO articles (user_id, category_id, image_id, text_id, views, tags, name, description, publish_at, id, created_at, updated_at, version) VALUES (1279976691204128, 1279976691204512, 1279976691204768, 1279976691205408, 0, 'abc,xyz,hello', 'vivamus. 3', 'alterum suspendisse potenti docendi libero idque liber tantas pulvinar.', 1557025248737, 1279976691208128, 1557025248753, 1557025248753, 0);
INSERT INTO texts (hash, content, id, created_at, updated_at, version) VALUES ('1056ce1242014665c99c481c1ec8780ca3afcacfad0913c51cf40efa75a4337c', '# fabellas definiebas ut solum postea saepe eirmod ut electram gloriatur.\n\ndignissim egestas accusata cu velit omittantur postulant falli usu ut qui sapientem maximus quis arcu theophrastus conceptam cras porttitor mutat.\n\ncetero dolor inimicus facilis consectetuer malesuada donec sententiae partiendo senectus etiam magnis eirmod mus elitr at eam delectus tamquam.\n\nfusce et epicuri lobortis leo atomorum hac mattis imperdiet luptatum honestatis parturient porro vitae quo lacinia.\n\ntibique nibh cursus duis perpetua eos iudicabit curabitur mutat causae reprehendunt.\n\ndetracto instructior tale laoreet postea nec eirmod putent senserit proin.\n\nsimul voluptaria primis duo possit fugit justo consetetur ponderum natoque est.\n\nelementum postea alienum urna sociosqu fermentum vitae similique risus urbanitas detracto an periculis bibendum.\n\niudicabit cras constituam numquam sonet elementum ocurreret explicari.\n\naudire malesuada augue hac ornare appareat pro pertinacia scelerisque an vidisse donec pellentesque prompta graeci ne varius constituto quaestio.\n\nvehicula.\n\nadolescens nascetur quot esse dicta indoctum indoctum oporteat mauris sed convenire.\n\nreprehendunt docendi veniam sit dolore ponderum tota suscipit verterem duis contentiones accommodare morbi posidonium tacimates bibendum doctus sociosqu maecenas fugit.\n\ndiam sociis noluisse volutpat graeci litora no morbi eos vitae in utamur percipit vidisse delenit ea habitant persius.\n\nvulputate sententiae efficitur viverra orci idque quis vivamus mediocrem.\n\n', 1279976691205440, 1557025248753, 1557025248753, 0);
INSERT INTO articles (user_id, category_id, image_id, text_id, views, tags, name, description, publish_at, id, created_at, updated_at, version) VALUES (1279976691204128, 1279976691204512, 1279976691204832, 1279976691205440, 0, 'abc,xyz,hello', 'pulvinar. 4', 'fabulas eripuit mus sapientem curae adversarium.', 1557025248738, 1279976691208160, 1557025248754, 1557025248754, 0);
INSERT INTO texts (hash, content, id, created_at, updated_at, version) VALUES ('4c11b8fe40e07eff972e610f433d3c9743bdd9e09944b5b3cb010fd71b322c06', '# debet delectus nunc contentiones iisque dicant deserunt interesset convenire.\n\ntantas diam verterem oporteat prompta in ponderum pharetra eius idque.\n\nne iudicabit.\n\nnominavi vim detraxit cetero repudiare eleifend unum.\n\nhas dicat.\n\nputent phasellus efficitur error agam tempus dictumst offendit malorum oratio tempor.\n\nocurreret donec vero aenean delectus offendit dicant dolorum justo dico falli habitant at postea accumsan.\n\nmalesuada ornatus ius magna regione minim equidem pro tantas sit nec facilisi dicam causae periculis primis intellegebat.\n\ntempor mutat feugait gloriatur risus dictum wisi errem omittam sociosqu dolores felis blandit imperdiet inimicus convenire mazim ius congue.\n\npraesent mei est voluptatum ignota ullamcorper mandamus cum etiam mandamus doctus ornare lorem.\n\nmolestie eleifend et utroque atomorum.\n\nphasellus decore lectus suspendisse eloquentiam facilis litora ferri tation elitr meliore iriure.\n\nnostra meliore fabulas dicit fuisset luptatum dolores assueverit quidam.\n\nlaudem interpretaris ius mandamus quis cursus periculis intellegat.\n\nmassa sententiae aeque pro.\n\ntheophrastus vix torquent fames gubergren convenire mi duo suscipit sed alterum justo.\n\nfeugiat id cras minim veritus fabulas ponderum.\n\nsed ne ocurreret possim inimicus dicant elaboraret potenti melius.\n\n', 1279976691205472, 1557025248754, 1557025248754, 0);
INSERT INTO articles (user_id, category_id, image_id, text_id, views, tags, name, description, publish_at, id, created_at, updated_at, version) VALUES (1279976691204128, 1279976691204512, 1279976691204896, 1279976691205472, 0, 'abc,xyz,hello', 'sociosqu. 5', 'cras platonem dicta senserit ridiculus.', 1557025248739, 1279976691208192, 1557025248754, 1557025248754, 0);
INSERT INTO texts (hash, content, id, created_at, updated_at, version) VALUES ('b0143dfba35cd0c6f64c9211f1a33caa790e7162d8ada89f6f5ab23afb81e466', '# vituperata dolor vestibulum mediocrem efficiantur doming dis phasellus prompta.\n\nocurreret falli populo aliquam scripserit eruditi debet dolores ridiculus facilisi.\n\nhendrerit in montes numquam nobis cubilia saperet risus rhoncus mazim instructior usu.\n\nhonestatis usu harum.\n\nnihil natum placerat.\n\nefficiantur nunc.\n\nturpis habeo recteque sociis eloquentiam gubergren saepe suas feugait.\n\nsodales mandamus dicit sollicitudin doming constituto quis scripserit reque dicam.\n\nvitae dolore mandamus evertitur urna nam ludus autem platea honestatis instructior voluptatibus malesuada quaerendum mea utroque gloriatur blandit.\n\nimpetus.\n\ntaciti epicurei veritus himenaeos dicat feugiat sodales lacinia equidem tota persequeris tempor iudicabit legimus natoque solet quaeque quaestio.\n\nnoluisse noluisse ut has principes dicam eruditi.\n\nmucius sem necessitatibus turpis esse fermentum nihil id habitant fabulas quisque.\n\n', 1279976691205504, 1557025248754, 1557025248754, 0);
INSERT INTO articles (user_id, category_id, image_id, text_id, views, tags, name, description, publish_at, id, created_at, updated_at, version) VALUES (1279976691204128, 1279976691204512, 1279976691204960, 1279976691205504, 0, 'abc,xyz,hello', 'alienum. 6', 'saperet dui accumsan audire docendi blandit dicam intellegebat sonet graecis.', 1557025248740, 1279976691208224, 1557025248754, 1557025248754, 0);
INSERT INTO texts (hash, content, id, created_at, updated_at, version) VALUES ('d685ac37470055b575a1e320070a78e722106495f7282247923a8688eda59274', '# delenit dolores sadipscing tristique solum.\n\npertinacia aeque veri suscipiantur faucibus eu constituto ac sodales.\n\nturpis est ridens atqui putent luctus moderatius mentitum adipiscing hac utroque populo placerat.\n\nlatine commune propriae solum parturient at quem.\n\naliquip magna delenit noluisse sociosqu eius errem ac sed dis dicta mea neque wisi.\n\nnovum litora deserunt vidisse mei.\n\nadolescens urna latine.\n\nsapien fabulas nunc tempor petentium veritus has platea liber adolescens ne euismod inciderint docendi harum consectetur delicata sale.\n\ncubilia eripuit equidem habitant dictas nibh ornare perpetua sodales eleifend quaerendum senectus inceptos porttitor risus.\n\nquisque euripidis tempor antiopam ne metus impetus mel laudem.\n\naperiri consul lacus ultrices taciti sem molestiae.\n\nmassa persius habemus convallis dapibus praesent mel.\n\nornatus alienum taciti ad pretium sadipscing proin tale suavitate mei cubilia regione urna saperet fastidii mentitum.\n\nrepudiandae ridens nascetur tractatos percipit vivamus labores inani idque corrumpit.\n\n', 1279976691205536, 1557025248754, 1557025248754, 0);
INSERT INTO articles (user_id, category_id, image_id, text_id, views, tags, name, description, publish_at, id, created_at, updated_at, version) VALUES (1279976691204128, 1279976691204512, 1279976691205024, 1279976691205536, 0, 'abc,xyz,hello', 'euripidis. 7', 'mediocrem voluptatibus nullam justo.', 1557025248741, 1279976691208256, 1557025248754, 1557025248754, 0);
INSERT INTO texts (hash, content, id, created_at, updated_at, version) VALUES ('ac9792dd7396e6ba8ff79f47327452ae00beef9f423fa0cf307742ff1486b514', '# ut invidunt vis.\n\niriure magna aperiri debet praesent vocibus ex.\n\nhabitant definitiones tantas porta inani perpetua phasellus lorem ultricies maiorum lectus ridiculus commune elementum tibique suspendisse magnis nonumes.\n\ntincidunt habemus doctus ridiculus ornare partiendo dolorum electram discere nec posuere omnesque numquam usu idque.\n\nepicurei similique deserunt.\n\ncurae ei eu saperet platea.\n\nnibh legimus ancillae nonumy rutrum malesuada dolorum mel qualisque ultricies.\n\nimpetus luptatum.\n\nultrices etiam scripta an.\n\nsenectus dicta porttitor tortor primis rhoncus ancillae appetere vestibulum assueverit accumsan bibendum discere ponderum cu ut option volutpat aliquam usu.\n\nquaeque detracto non ea reprimique gravida tacimates.\n\nporro purus decore rutrum explicari quis.\n\ncommune assueverit an senserit elementum suspendisse.\n\nsigniferumque eget constituam intellegat consectetuer reformidans vix feugiat sapien.\n\nnunc auctor saepe dicit pulvinar conclusionemque phasellus evertitur splendide luptatum condimentum facilis.\n\ndelicata turpis dicit labores pretium indoctum nobis nostrum.\n\nvestibulum civibus solum eius consetetur assueverit principes atomorum.\n\ntempus nullam harum possim altera suscipit netus nostra sadipscing sociosqu cubilia cetero platonem tritani eget at electram.\n\nexpetenda referrentur ius himenaeos per venenatis neglegentur quidam aenean.\n\ncetero aenean voluptatibus novum accusata molestiae.\n\n', 1279976691205568, 1557025248754, 1557025248754, 0);
INSERT INTO articles (user_id, category_id, image_id, text_id, views, tags, name, description, publish_at, id, created_at, updated_at, version) VALUES (1279976691204128, 1279976691204512, 1279976691205088, 1279976691205568, 0, 'abc,xyz,hello', 'consul. 8', 'magnis aptent magna wisi evertitur efficitur conceptam docendi.', 1557025248742, 1279976691208288, 1557025248755, 1557025248755, 0);
INSERT INTO texts (hash, content, id, created_at, updated_at, version) VALUES ('7eb4e17cb1f6bb4164d961dd97ed285f1f7d4030829a1754a6ff7528e2ae80f0', '# tacimates affert sed suavitate graecis.\n\naliquam ornatus eos sagittis ferri unum vivamus ridiculus.\n\nphasellus interpretaris reque suspendisse velit cum consequat veri laoreet.\n\npersecuti fugit vocent prodesset qui electram sea malorum amet taciti iisque viris ligula voluptatum electram detracto habitant primis.\n\na ocurreret efficitur malorum delectus consul vituperatoribus adolescens senserit.\n\nadolescens at maiorum theophrastus delectus harum detracto liber veniam fringilla iaculis imperdiet molestie vis posuere porro.\n\ninteger posse theophrastus suspendisse dolore expetendis verear.\n\nsapien posidonium et pretium.\n\neos fabellas percipit.\n\nquod dignissim suscipiantur platonem nullam senectus mollis ad prodesset nibh discere sed agam.\n\nconubia purus vestibulum percipit autem antiopam utinam ornatus persequeris iaculis mattis justo duis dolore rutrum scelerisque varius movet.\n\nullamcorper nulla brute prodesset sit reprehendunt recteque tellus percipit saepe laudem suas praesent volutpat fastidii pericula patrioque.\n\neget corrumpit wisi aliquid dis massa interpretaris viris mandamus litora iudicabit dui luctus porta prodesset.\n\nnullam maecenas nobis malorum et atqui maecenas neque sociis conclusionemque contentiones ut agam tristique quas delectus comprehensam tibique senectus lacinia.\n\nconsetetur ridiculus viris primis tristique lectus.\n\nalienum movet natum lacinia fastidii errem volumus mus nibh affert idque aliquet harum adolescens.\n\nhinc quaestio dictum dolor civibus ridiculus molestie suscipiantur honestatis alterum omittam blandit interpretaris qui convallis imperdiet.\n\n', 1279976691205600, 1557025248755, 1557025248755, 0);
INSERT INTO articles (user_id, category_id, image_id, text_id, views, tags, name, description, publish_at, id, created_at, updated_at, version) VALUES (1279976691204128, 1279976691204512, 1279976691205152, 1279976691205600, 0, 'abc,xyz,hello', 'scripserit. 9', 'praesent maiorum quaerendum dapibus quaeque putent.', 1557025248743, 1279976691208320, 1557025248755, 1557025248755, 0);
INSERT INTO texts (hash, content, id, created_at, updated_at, version) VALUES ('a42fec4aa2d88bc01a25372ddbb8fb1699f7b2194b7368c53c000c030ce1c8ee', '# vocent appetere aliquet deserunt ridiculus tota noster constituto.\n\nvehicula feugait qui hinc eos nostrum reprimique inani mattis.\n\nvitae maiestatis suscipiantur prompta mediocritatem class leo magna id penatibus aliquip.\n\ntibique platea eleifend massa.\n\nimperdiet dicit ipsum tellus quaerendum nisl vix percipit causae explicari.\n\nnominavi dicat fermentum debet lacinia hendrerit elaboraret legere himenaeos veniam antiopam erroribus habitasse.\n\ndoctus referrentur tincidunt.\n\nsuavitate non wisi curabitur tractatos purus cetero viris invidunt.\n\nferri duis pri dicam massa dicta falli dicat nostra aliquet purus erat fabulas nostra.\n\nanimal montes sententiae maecenas mutat adversarium vix in nascetur propriae mediocrem rhoncus ea quo nam moderatius veri lobortis.\n\nadversarium a parturient solum primis fringilla iriure vivendo regione ac metus periculis facilisi hinc senectus taciti nunc no delenit ornare.\n\npertinacia.\n\neripuit lacinia viris nullam mi delicata tation fames conubia quaerendum utamur liber reque hendrerit faucibus detracto posidonium menandri feugait.\n\nelit porro dolorem auctor.\n\nconstituam veniam euripidis explicari sapientem senserit nullam nibh pharetra persecuti dissentiunt finibus legimus libero sodales senserit equidem odio.\n\nmus singulis veritus recteque gravida class gravida fusce prodesset mauris quam vitae.\n\nsadipscing causae vim volutpat molestiae facilisis sumo fermentum dolor vel porta corrumpit malesuada delicata.\n\nsuas adversarium mediocritatem taciti.\n\n', 1279976691205632, 1557025248755, 1557025248755, 0);
INSERT INTO articles (user_id, category_id, image_id, text_id, views, tags, name, description, publish_at, id, created_at, updated_at, version) VALUES (1279976691204128, 1279976691204512, 1279976691205216, 1279976691205632, 0, 'abc,xyz,hello', 'nec. 10', 'partiendo quis ultricies esse regione.', 1557025248744, 1279976691208352, 1557025248755, 1557025248755, 0);
INSERT INTO texts (hash, content, id, created_at, updated_at, version) VALUES ('e700a0ffd8dac5aa99197f1421380861beb7a013ee8d8f38932d153caa117d12', '# deterruisset noster aliquam reque maecenas.\n\nintellegebat nam scelerisque vocent quaerendum tation omittantur suscipit dui justo pellentesque expetendis vel reprimique aliquid quidam error necessitatibus ea.\n\nlatine maiorum mattis diam reprehendunt quot eum vestibulum quaerendum consectetur gloriatur dicant a veritus movet.\n\nconsul tacimates luctus invenire senectus.\n\nultrices aenean.\n\nhimenaeos agam suscipit sapien conubia molestie molestiae euripidis.\n\nsollicitudin gloriatur quod dignissim tation cursus conubia tractatos.\n\ndisputationi utamur verear ultrices principes a feugait altera mnesarchum accommodare nam molestiae antiopam ubique nisl maiorum sollicitudin pericula.\n\nquot vulputate appetere errem civibus eleifend harum mucius sumo montes definitiones ultricies habemus fuisset partiendo omittam augue instructior.\n\ndui regione nascetur ubique et esse nascetur usu.\n\nnam lectus saperet ad periculis.\n\nhonestatis offendit quisque intellegebat minim porttitor inimicus possim interpretaris sed aliquam nominavi liber sem atqui ornare gubergren.\n\nmagna consetetur elit epicuri sociis saepe putent.\n\npenatibus ubique cursus alia appareat sale aenean diam conclusionemque offendit dico.\n\nreque alia ullamcorper.\n\n', 1279976691205664, 1557025248755, 1557025248755, 0);
INSERT INTO articles (user_id, category_id, image_id, text_id, views, tags, name, description, publish_at, id, created_at, updated_at, version) VALUES (1279976691204128, 1279976691204512, 1279976691205280, 1279976691205664, 0, 'abc,xyz,hello', 'perpetua. 11', 'mediocrem epicurei vivendo odio utinam oporteat.', 1557025248745, 1279976691208384, 1557025248755, 1557025248755, 0);
