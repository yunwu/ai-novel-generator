package com.ai.novel.generator.service;

@Slf4j
@Service
public class TongYiImagesServiceImpl extends AbstractTongYiServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(TongYiService.class);
    private final ImageClient imageClient;
    @Autowired
    public TongYiImagesServiceImpl(ImageClient client) {
        this.imageClient = client;
    }
    @Override
    public ImageResponse genImg(String imgPrompt) {
        var prompt = new ImagePrompt(imgPrompt);
        return imageClient.call(prompt);
    }
}
